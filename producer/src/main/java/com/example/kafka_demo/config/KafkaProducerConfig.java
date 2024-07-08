package com.example.kafka_demo.config;

import com.example.kafka_demo.model.Person;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.key-serializer}")
    private String keySerializer;

    @Value("${spring.kafka.value-serializer}")
    private String valueSerializer;

    @Bean
    public KafkaTemplate<Integer, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
    @Bean
    public ProducerFactory<Integer, String> producerFactory() {
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, keySerializer);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, valueSerializer);
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }
}