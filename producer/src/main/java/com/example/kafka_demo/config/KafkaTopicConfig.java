package com.example.kafka_demo.config;

import com.example.kafka_demo.util.KafkaUtils;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic demoTopic(){
        return TopicBuilder
                .name(KafkaUtils.demoTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic personTopic(){
        return TopicBuilder
                .name(KafkaUtils.personTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
    @Bean
    public NewTopic StringTopic(){
        return TopicBuilder
                .name(KafkaUtils.StringTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }

    public NewTopic jsonTopic(){
        return TopicBuilder
                .name(KafkaUtils.JsonTopic)
                .partitions(1)
                .replicas(1)
                .build();
    }
}
