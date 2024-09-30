package com.example.kafkademo.service;

import com.example.kafkademo.model.Person;
import com.example.kafkademo.model.generated.Order;
import com.example.kafkademo.model.generated.PersonAvro;
import com.example.kafkademo.util.KafkaUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
public class NotificationService {
    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);


    public LocalDateTime currentTime;

    private KafkaUtils kafkaUtils;

    @Autowired
    public NotificationService(KafkaUtils kafkaUtils) {
        this.kafkaUtils = kafkaUtils;
    }

    @KafkaListener(topics = "#{kafkaUtils.personTopic}",
            groupId = "#{kafkaUtils.groupId}",
            containerFactory = "personAvroKafkaListenerContainerFactory",
            properties = "auto.offset.reset:earliest"
    )
    public void read(ConsumerRecord<String, PersonAvro> consumerRecord) {

        currentTime = LocalDateTime.now();

        logger.info("Avro message received - Topic: {}, Value: {}, Produced at: {}",
                consumerRecord.topic(), consumerRecord.value(), currentTime);
    }


    @KafkaListener(topics = "#{kafkaUtils.demoTopic}",
            groupId = "#{kafkaUtils.groupId}",
            containerFactory = "orderAvroKafkaListenerContainerFactory",
            properties = "auto.offset.reset:earliest")
    public void consume(ConsumerRecord<String, Order> event) {

        currentTime = LocalDateTime.now();

        logger.info("Avro message  received - Topic: {}, Value: {}, Produced at: {}",
                event.topic(), event.value(), currentTime);
    }


    @KafkaListener(topics = "#{kafkaUtils.StringTopic}",
            groupId = "#{kafkaUtils.groupId}",
            containerFactory = "stringKafkaListenerContainerFactory",
            properties = "auto.offset.reset:earliest"
    )
    public void consumeStringPerson(ConsumerRecord<String, String> consumerRecord) {

        currentTime = LocalDateTime.now();

        logger.info("String message received - Topic: {}, Value: {}, Produced at: {}",
                consumerRecord.topic(), consumerRecord.value(), currentTime);

    }


    @KafkaListener(topics = "#{kafkaUtils.JsonTopic}",
            groupId = "#{kafkaUtils.groupId}",
            containerFactory = "jsonKafkaListenerContainerFactory",
            properties = "auto.offset.reset:earliest"
    )
    public void consumeJsonPerson(ConsumerRecord<String, Person> consumerRecord) {

        currentTime = LocalDateTime.now();

        logger.info("JSON message received - Topic: {}, Value: {}, Produced at: {}",
                consumerRecord.topic(), consumerRecord.value(), currentTime);

    }


}
