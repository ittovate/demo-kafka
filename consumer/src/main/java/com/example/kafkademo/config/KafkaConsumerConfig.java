package com.example.kafkademo.config;


import com.example.kafkademo.model.generated.Order;
import com.example.kafkademo.model.generated.PersonAvro;
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;

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

    @Value("${spring.kafka.specific-avro-reader}")
    private String specificAvroReader;

    @Value("${spring.kafka.schema-registry-url}")
    private String schemaRegistryUrl;

    @Value("${spring.kafka.autoOffsetReset}")
    private String autoOffsetReset;

    @Value("${spring.kafka.Value-Avro-Deserializer}")
    private String ValueAvroDeserializer;


    @Value("${spring.kafka.value-deserializer}")
    private String JsonDeserializer;


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, PersonAvro> personAvroKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, PersonAvro> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(avroConsumerFactory());
        return factory;
    }


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Order> orderAvroKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Order> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(avroConsumerFactory());
        return factory;
    }


    @Bean
    public <T> ConsumerFactory<String, Object> avroConsumerFactory() {
        Map<String, Object> consumerProperties = new HashMap<>();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProperties.put(KafkaAvroDeserializerConfig.SCHEMA_REGISTRY_URL_CONFIG, schemaRegistryUrl);
        consumerProperties.put(KafkaAvroDeserializerConfig.SPECIFIC_AVRO_READER_CONFIG, specificAvroReader);
        consumerProperties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, stringDeserializer);
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ValueAvroDeserializer);


        return new DefaultKafkaConsumerFactory<>(consumerProperties);
    }


    @Bean
    Map<String, Object> stringConsumerProperties() {
        Map<String, Object> consumerProperties = new HashMap<>();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, stringDeserializer);
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, stringDeserializer);
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        return consumerProperties;
    }

    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> stringKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory
                = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(stringConsumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, String> stringConsumerFactory() {
        return new DefaultKafkaConsumerFactory<>(stringConsumerProperties());
    }


    @Bean
    public KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, Object>> jsonKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        return factory;
    }

    @Bean
    public ConsumerFactory<String, Object> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(jsonConsumerProperties());
    }


    @Bean
    Map<String, Object> jsonConsumerProperties() {
        Map<String, Object> consumerProperties = new HashMap<>();
        consumerProperties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        consumerProperties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, stringDeserializer);
        consumerProperties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, jsonDeserializer);
        consumerProperties.put(ConsumerConfig.GROUP_ID_CONFIG, consumerGroupId);
        return consumerProperties;
    }


}


