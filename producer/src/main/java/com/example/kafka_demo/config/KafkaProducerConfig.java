package com.example.kafka_demo.config;

import com.example.kafka_demo.model.Person;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.integer-serializer}")
    private String integerSerializer;

    @Value("${spring.kafka.string-serializer}")
    private String stringSerializer;

    @Value("${spring.kafka.json-serializer}")
    private String jsonSerializer;



    @Bean
    public KafkaTemplate<Integer, String> stringKafkaTemplate(){
        return new KafkaTemplate<>(stringProducerFactory());
    }
    @Bean
    public KafkaTemplate<Integer, Person> jsonKafkaTemplate(){
        return new KafkaTemplate<>(jsonProducerFactory());
    }
    @Bean
    public ProducerFactory<Integer, String> stringProducerFactory() {
        System.out.println("--------------Check 1  stringProducerFactory  ");
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, integerSerializer);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, stringSerializer );
        System.out.println("----------Check 2  stringProducerFactory  ");
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }

    @Bean
    public ProducerFactory<Integer, Person> jsonProducerFactory() {
        System.out.println("--------------Check 1  jsonProducerFactory  ");
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, integerSerializer);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, jsonSerializer);
        System.out.println("--------------Check 1  jsonProducerFactory  ");
        return new DefaultKafkaProducerFactory<>(producerProperties) ;
    }
}