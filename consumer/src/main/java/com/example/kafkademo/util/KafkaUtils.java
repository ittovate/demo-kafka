package com.example.kafkademo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaUtils {
    @Value("${spring.kafka.topic.default-topic}")
    private String demoTopic;

    @Value("${spring.kafka.consumer-group-id}")
    private String groupId;

    @Value("${spring.kafka.topic.person-topic}")
    private String personTopic;

    @Value("${spring.kafka.topic.String-topic}")
    private String stringTopic;


    @Value("${spring.kafka.topic.Json-topic}")
    private String jsonTopic;

    public String getJsonTopic() {
        return jsonTopic;
    }

    public String getStringTopic() {
        return stringTopic;
    }

    public String getDemoTopic() {
        return demoTopic;
    }

    public String getGroupId() {
        return groupId;
    }

    public String getPersonTopic() {
        return personTopic;
    }
}
