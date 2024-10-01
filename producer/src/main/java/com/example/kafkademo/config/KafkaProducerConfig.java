package com.example.kafkademo.config;

import com.example.kafkademo.model.Person;
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

    @Value("${spring.kafka.avro-serializer}")
    private String avroSerializer;

    @Value("${spring.kafka.schema-registry-url}")
    private String schemaRegistryUrl;

    /**
     * String kafka template kafka template.
     *
     * @return the kafka template
     */
    @Bean
    public KafkaTemplate<Integer, String> stringKafkaTemplate() {
        return new KafkaTemplate<>(stringProducerFactory());
    }

    /**
     * Avro kafka template kafka template.
     *
     * @param <T> the type parameter
     * @return the kafka template
     */
    @Bean
    public <T> KafkaTemplate<String, T> avroKafkaTemplate() {
        return new KafkaTemplate<>(avroProducerFactory());
    }


    /**
     * Json kafka template kafka template.
     *
     * @return the kafka template
     */
    @Bean
    public KafkaTemplate<Integer, Person> jsonKafkaTemplate() {
        return new KafkaTemplate<>(jsonProducerFactory());
    }


    /**
     * String producer factory producer factory.
     *
     * @return the producer factory
     */
    @Bean
    public ProducerFactory<Integer, String> stringProducerFactory() {
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, stringSerializer);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, stringSerializer);
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }

    /**
     * Avro producer factory producer factory.
     *
     * @param <T> the type parameter
     * @return the producer factory
     */
    @Bean
    public <T> ProducerFactory<String, T> avroProducerFactory() {

        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, stringSerializer);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, avroSerializer);
        producerProperties.put("schema.registry.url", schemaRegistryUrl);
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }


    /**
     * Json producer factory producer factory.
     *
     * @return the producer factory
     */
    @Bean
    public ProducerFactory<Integer, Person> jsonProducerFactory() {
        Map<String, Object> producerProperties = new HashMap<>();
        producerProperties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        producerProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, integerSerializer);
        producerProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, jsonSerializer);
        return new DefaultKafkaProducerFactory<>(producerProperties);
    }
}
