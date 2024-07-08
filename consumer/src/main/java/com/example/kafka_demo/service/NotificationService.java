package com.example.kafka_demo.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Service
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);
    private static final DateTimeFormatter formatter = DateTimeFormatter
            .ofPattern("yyyy-MM-dd HH:mm:ss")
            .withZone(ZoneId.systemDefault());
    @KafkaListener(topics = "demo-topic",
            groupId = "notifications-consumer-group",
            properties = "auto.offset.reset:earliest")
    void consume(ConsumerRecord<Integer,String> event){
        Instant eventInstant = Instant.ofEpochMilli(event.timestamp());
        String formattedTimestamp = formatter.format(eventInstant);

        logger.info("Consumed event and sending notification to "
                + event.value() + " which was produced at " + formattedTimestamp);

    }
}
