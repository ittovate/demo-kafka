package com.example.kafka_demo.config;


import com.example.kafka_demo.model.Person;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.IntegerDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConsumerConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.integer-deserializer}")
    private String integerDeserializer;

    @Value("${spring.kafka.string-deserializer}")
    private String stringDeserializer;

    @Value("${spring.kafka.json-deserializer}")
    private String jsonDeserializer;

    @Value("${spring.kafka.consumer-group-id}")
    private String consumerGroupId;

    Map<String,Object> stringConsumerProperties(){
        Map<String,Object> consumerProperties = new HashMap<>();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, integerDeserializer);
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, stringDeserializer);
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG,consumerGroupId);
        return consumerProperties;
    }

    Map<String,Object> jsonConsumerProperties(){
        Map<String,Object> consumerProperties = new HashMap<>();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, integerDeserializer);
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, jsonDeserializer);
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG,consumerGroupId);
        consumerProperties.put(JsonDeserializer.TRUSTED_PACKAGES,"com.example.kafka_demo.model");
        return consumerProperties;
    }

    @Bean
    public ConsumerFactory<Integer,String> stringConsumerFactory(){
        return new DefaultKafkaConsumerFactory<>(stringConsumerProperties());
    }
    @Bean
    public ConsumerFactory<Integer,Person> jsonConsumerFactory(){
        return new DefaultKafkaConsumerFactory<>(jsonConsumerProperties());
    }
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>> stringKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(stringConsumerFactory());
        return factory;
    }
    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, Person>> jsonKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<Integer, Person> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(jsonConsumerFactory());
        return factory;
    }

}
