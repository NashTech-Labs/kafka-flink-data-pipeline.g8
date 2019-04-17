package com.knoldus.demo.flink;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer011;

import java.util.Properties;

public class FlinkKafkaConsumer {
    
    private Config conf = ConfigFactory.load();

    public FlinkKafkaConsumer011<String> createStringConsumerForTopic(
            String topic, String kafkaGroup) {
        
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", conf.getString("kafka.brokers"));
        props.setProperty("group.id", kafkaGroup);
        FlinkKafkaConsumer011<String> consumer = new FlinkKafkaConsumer011<>(
                topic, new SimpleStringSchema(), props);
        
        return consumer;
    }
    
}
