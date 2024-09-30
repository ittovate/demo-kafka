package com.example.kafkademo.config;

import com.example.kafkademo.constant.KafkaConstant;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic demoTopic(){
        return TopicBuilder
                .name(KafkaConstant.DEMO_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic personTopic(){
        return TopicBuilder
                .name(KafkaConstant.PERSON_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic stringTopic(){
        return TopicBuilder
                .name(KafkaConstant.STRING_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }

    public NewTopic jsonTopic(){
        return TopicBuilder
                .name(KafkaConstant.JSON_TOPIC)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
