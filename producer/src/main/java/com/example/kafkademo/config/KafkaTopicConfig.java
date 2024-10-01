package com.example.kafkademo.config;

import com.example.kafkademo.constant.KafkaConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import static com.example.kafkademo.constant.KafkaConstant.PARTITION_COUNT;
import static com.example.kafkademo.constant.KafkaConstant.REPLICATION_COUNT;

@Configuration
public class KafkaTopicConfig {
    /**
     * Demo topic new topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic demoTopic() {
        return TopicBuilder
                .name(KafkaConstant.DEMO_TOPIC)
                .partitions(PARTITION_COUNT)
                .replicas(REPLICATION_COUNT)
                .build();
    }

    /**
     * Person topic new topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic personTopic() {
        return TopicBuilder
                .name(KafkaConstant.PERSON_TOPIC)
                .partitions(PARTITION_COUNT)
                .replicas(REPLICATION_COUNT)
                .build();
    }

    /**
     * String topic new topic.
     *
     * @return the new topic
     */
    @Bean
    public NewTopic stringTopic() {
        return TopicBuilder
                .name(KafkaConstant.STRING_TOPIC)
                .partitions(PARTITION_COUNT)
                .replicas(REPLICATION_COUNT)
                .build();
    }

    /**
     * Json topic new topic.
     *
     * @return the new topic
     */
    public NewTopic jsonTopic() {
        return TopicBuilder
                .name(KafkaConstant.JSON_TOPIC)
                .partitions(PARTITION_COUNT)
                .replicas(REPLICATION_COUNT)
                .build();
    }
}
