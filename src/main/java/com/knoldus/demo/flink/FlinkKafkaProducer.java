package com.knoldus.demo.flink;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;

public class FlinkKafkaProducer {
    
    private Config conf = ConfigFactory.load();
    
    public FlinkKafkaProducer011<String> createStringProducer(
            String topic) {
        
        return new FlinkKafkaProducer011<>(conf.getString("kafka.brokers"),
                topic, new SimpleStringSchema());
    }
}
