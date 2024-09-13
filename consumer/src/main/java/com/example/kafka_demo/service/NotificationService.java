package com.example.kafka_demo.service;

import com.example.kafka_demo.model.generated.PersonAvro;
import com.example.kafka_demo.util.KafkaUtils;
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


    private LocalDateTime currentTime;

    private KafkaUtils kafkaUtils;  // Inject KafkaUtils


    @Autowired
    public NotificationService(KafkaUtils kafkaUtils) {
        this.kafkaUtils = kafkaUtils;
    }

    @KafkaListener(topics =  "#{kafkaUtils.personTopic}" ,
                   groupId = "#{kafkaUtils.groupId}",
                  containerFactory = "personAvroKafkaListenerContainerFactory"
                         )
    public void read(ConsumerRecord<String, PersonAvro> consumerRecord) {
        String key = consumerRecord.key();
        PersonAvro person = consumerRecord.value();

            currentTime = LocalDateTime.now();

        logger.info("Avro message received for key : " + key + " value : " + person.toString()
                     +  " which was produced at " + currentTime ) ;

    }




    @KafkaListener(topics =  "#{kafkaUtils.demoTopic}" ,
                   groupId = "#{kafkaUtils.groupId}" ,
                   containerFactory = "orderAvroKafkaListenerContainerFactory",
                   properties = "auto.offset.reset:earliest")
    void consume(ConsumerRecord<String , PersonAvro> event){

        currentTime = LocalDateTime.now();

        logger.info("Consumed event and sending notification to  "
                + event.value() + " which was produced at " + currentTime );

    }


}
