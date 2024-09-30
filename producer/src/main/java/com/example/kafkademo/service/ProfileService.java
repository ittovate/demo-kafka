
package com.example.kafkademo.service;

import static com.example.kafkademo.constant.AppConstant.SIMULATING_SLEEP_MS;

import com.example.kafkademo.model.Person;
import com.example.kafkademo.constant.KafkaConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


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
        kafkaTemplate.send(KafkaConstant.JSON_TOPIC,(Person) value);
    }

    @Override
    public void sendKafkaEventSync(Object value) throws InterruptedException {
        kafkaTemplate.send(KafkaConstant.JSON_TOPIC,(Person) value);
        Thread.sleep(SIMULATING_SLEEP_MS); //Simulating sync behaviour

    }

    public void sendPersonDetailsSync(Person person)
            throws InterruptedException {
         sendKafkaEventSync(person);
    }


    public void sendPersonDetailsAsync(Person person){
        sendKafkaEventAsync(person);
        logger.info("Person details sent successfully!");
    }


}

