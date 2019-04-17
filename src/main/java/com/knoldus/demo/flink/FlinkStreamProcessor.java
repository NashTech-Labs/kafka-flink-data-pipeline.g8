package com.knoldus.demo.flink;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

public class FlinkStreamProcessor {
    
    private Config conf = ConfigFactory.load();
    
    private static FlinkKafkaProducer flinkKafkaProducer = new FlinkKafkaProducer();
    private static FlinkKafkaConsumer flinkKafkaConsumer = new FlinkKafkaConsumer();
    private String inputTopic = conf.getString("kafka.input.topic");
    private String outputTopic = conf.getString("kafka.output.topic");
    private String consumerGroup = "flink-stream-processing";
    
    public Long capitalize() throws Exception {
        
        StreamExecutionEnvironment environment = StreamExecutionEnvironment
                .getExecutionEnvironment();
        
        DataStream<String> stringInputStream = environment
                .addSource(flinkKafkaConsumer.createStringConsumerForTopic(inputTopic, consumerGroup).setStartFromEarliest());
        
        stringInputStream
                .map(new WordsCapitalizer())
                .addSink(flinkKafkaProducer.createStringProducer(outputTopic));
        return environment.execute().getNetRuntime();
    }
}
