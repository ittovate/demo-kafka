
package com.example.kafka_demo.service;

import com.example.kafka_demo.model.Person;
import com.example.kafka_demo.util.KafkaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class ProfileService implements KafkaMessageServiceSync, KafkaMessageServiceAsync{
    private final KafkaTemplate<Integer, Person> kafkaTemplate;



    private final Logger logger = LoggerFactory.getLogger(ProfileService.class);


     @Autowired
    public ProfileService(KafkaTemplate<Integer, Person> kafkaTemplate ) {
        this.kafkaTemplate = kafkaTemplate;

    }

    @Override
    public void sendKafkaEventAsync(Object value) {
        logger.info("Sending asynchronous to kafka topic {" + KafkaUtils.demoTopic + " }");
        kafkaTemplate.send(KafkaUtils.personTopic,(Person) value);
    }

    @Override
    public void sendKafkaEventSync(Object value) throws ExecutionException, InterruptedException, TimeoutException {
        logger.info("Sending synchronous to kafka topic {" + KafkaUtils.demoTopic + "}");
        kafkaTemplate.send(KafkaUtils.personTopic,(Person) value).get(10, TimeUnit.SECONDS);
        Thread.sleep(5000); //Simulating sync behaviour
    }

    public void sendPersonDetailsSync(Person person){
        try{
            sendKafkaEventSync(person);
        }catch (ExecutionException | InterruptedException | TimeoutException exception){
            logger.error("Error when sending synchronous to Kafka");
            logger.error(exception.getMessage());
        }
    }


    public void sendPersonDetailsAsync(Person person){
        sendKafkaEventAsync(person);
        logger.info("Person details sent successfully!");
    }


}

