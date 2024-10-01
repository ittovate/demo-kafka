package com.example.kafkademo.service;

import static com.example.kafkademo.constant.ServiceConstant.SIMULATING_SLEEP_MS;

import com.example.kafkademo.model.generated.PersonAvro;
import com.example.kafkademo.constant.KafkaConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


/**
 * The type Profile avro service.
 */
@Service
public class ProfileAvroService implements KafkaMessageServiceSync {

    private final Logger logger = LoggerFactory.getLogger(ProfileAvroService.class);
    private final KafkaTemplate<String, PersonAvro> kafkaTemplate;

    /**
     * Instantiates a new Profile avro service.
     *
     * @param kafkaTemplate the kafka template
     */
    public ProfileAvroService(KafkaTemplate<String, PersonAvro> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendKafkaEventSync(Object value) throws InterruptedException {
        kafkaTemplate.send(KafkaConstant.PERSON_TOPIC, (PersonAvro) value);
        Thread.sleep(SIMULATING_SLEEP_MS); //Simulating sync behaviour
    }


    /**
     * Send profile details avro sync.
     *
     * @param person the person
     * @throws InterruptedException the interrupted exception
     */
    public void sendProfileDetailsAvroSync(PersonAvro person)
            throws InterruptedException {
        sendKafkaEventSync(person);
    }


}
