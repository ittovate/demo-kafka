package com.example.kafka_demo.util;

import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class KafkaUtils {
   @Value("${spring.kafka.topic.default-topic}")
   private  String demoTopic;

    @Value("${spring.kafka.consumer-group-id}")
    private  String groupId;

    @Value("${spring.kafka.topic.person-topic}")
    private   String  personTopic ;

    public  String getDemoTopic() {
        return demoTopic;
    }

    public  String getGroupId() {
        return groupId;
    }

    public  String getPersonTopic() {
        return personTopic;
    }
}
