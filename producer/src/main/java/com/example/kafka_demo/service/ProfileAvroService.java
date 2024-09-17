package com.example.kafka_demo.service;

import com.example.kafka_demo.model.generated.PersonAvro;
import com.example.kafka_demo.util.KafkaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class ProfileAvroService implements KafkaMessageServiceSync{

    private final Logger logger = LoggerFactory.getLogger(ProfileAvroService.class) ;
    private final KafkaTemplate<String, PersonAvro> kafkaTemplate;

    public ProfileAvroService(KafkaTemplate<String, PersonAvro> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendKafkaEventSync(Object value) throws ExecutionException, InterruptedException, TimeoutException {

        kafkaTemplate.send(KafkaUtils.personTopic,(PersonAvro) value).get(10, TimeUnit.SECONDS);
        logger.info("avro Sending synchronous to kafka topic {" + KafkaUtils.personTopic + "}");

        Thread.sleep(5000); //Simulating sync behaviour
    }



    public void sendProfileDetailsAvroSync( PersonAvro person) {
        try{
            sendKafkaEventSync(person);
        }catch (ExecutionException | InterruptedException | TimeoutException exception){
            logger.error("Error when sending avro synchronous to Kafka");
            logger.error(exception.getMessage());
        }
    }


}
