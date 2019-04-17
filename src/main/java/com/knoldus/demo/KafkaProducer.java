package com.knoldus.demo;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class KafkaProducer {
    
    private Config conf = ConfigFactory.load();
    
    public void produceRecords() {
        Producer<String, String> producer = createProducer();
        for (int index = 0; index < 100; index++) {
            ProducerRecord<String, String> record = new ProducerRecord<String, String>(conf.getString("kafka.input.topic"),
                    "record version " + index);
            try {
                RecordMetadata metadata = producer.send(record).get();
                System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            } catch (ExecutionException | InterruptedException e) {
                System.out.println("Error in sending record");
                System.out.println(e);
            }
        }
    }
    
    private Producer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, conf.getString("kafka.brokers"));
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "kafka-producer-test-v1");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new org.apache.kafka.clients.producer.KafkaProducer<>(props);
    }
    
    public static void main(String[] args) {
        KafkaProducer kf=new KafkaProducer();
        kf.produceRecords();
    }
}
