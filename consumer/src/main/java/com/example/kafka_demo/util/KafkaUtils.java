package com.example.kafka_demo.util;

import org.springframework.beans.factory.annotation.Value;

public class KafkaUtils {
    @Value("${spring.kafka.default-topic}")
    public static String demoTopic;

    @Value("${spring.kafka.consumer-group-id}")
    public static String groupId;
}
