package com.example.kafka_demo.service;

import com.example.kafka_demo.model.Person;
import com.example.kafka_demo.util.KafkaUtils;
import org.apache.kafka.common.protocol.types.Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class OrderService implements KafkaMessageServiceSync,KafkaMessageServiceAsync{
    KafkaTemplate<Integer, String> kafkaTemplate;
    Logger logger = LoggerFactory.getLogger(OrderService.class);

    public OrderService(KafkaTemplate<Integer, String> kafkaTemplate){
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendKafkaEventAsync(Object value){
        logger.info("Sending asynchronous to kafka topic {" + KafkaUtils.demoTopic + " }");
        kafkaTemplate.send(KafkaUtils.demoTopic,(String)value);
    }

    @Override
    public void sendKafkaEventSync(Object value) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("Check 3 service  ");
        logger.info("Sending synchronous to kafka topic {" + KafkaUtils.demoTopic + "}");
        System.out.println("Check 4 service  ");
        kafkaTemplate.send(KafkaUtils.demoTopic,(String) value).get(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        System.out.println("Check 5 service  ");//Simulating sync behaviour
    }

    public void makeOrderSync(String email){
        try{
            System.out.println("Check 1 service  ");
            sendKafkaEventSync(email);
        }catch (ExecutionException | InterruptedException | TimeoutException exception){
            System.out.println("Check 2 service  ");
            logger.error("Error when sending synchronous to Kafka");
            logger.error(exception.getMessage());
        }
    }
    public void makeOrderAsync(String email){
        sendKafkaEventAsync(email);
        logger.info("Notification sent successfully!");
    }
}
