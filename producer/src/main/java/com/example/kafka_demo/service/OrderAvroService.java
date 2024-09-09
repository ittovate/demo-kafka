package com.example.kafka_demo.service;

import com.example.kafka_demo.model.generated.Order;
import com.example.kafka_demo.util.KafkaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class OrderAvroService implements KafkaMessageServiceSync{
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(OrderAvroService.class);

    public OrderAvroService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendKafkaEventSync(Object value) throws ExecutionException, InterruptedException, TimeoutException {
        System.out.println("Check 3 service  ");
        logger.info("Sending synchronous to kafka topic {" + KafkaUtils.demoTopic + "}");
        System.out.println("Check 4 service  ");
        kafkaTemplate.send(KafkaUtils.demoTopic,(Order) value).get(10, TimeUnit.SECONDS);
        Thread.sleep(5000);
        System.out.println("Check 5 service  ");//Simulating sync behaviour
    }
}
