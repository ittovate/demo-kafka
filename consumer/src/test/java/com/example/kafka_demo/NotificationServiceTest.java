package com.example.kafka_demo;

import com.example.kafka_demo.model.Person;
import com.example.kafka_demo.model.generated.Order;
import com.example.kafka_demo.model.generated.PersonAvro;
import com.example.kafka_demo.service.NotificationService;
import com.example.kafka_demo.util.KafkaUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

@SpringBootTest
class NotificationServiceTest {

    @Mock
    private KafkaUtils kafkaUtils;



    public LocalDateTime currentTime;

    private NotificationService notificationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        notificationService = new NotificationService(kafkaUtils);
    }

    @Test
    void testRead() {
        ConsumerRecord<String, PersonAvro> consumerRecord = mock(ConsumerRecord.class);

        when(consumerRecord.topic()).thenReturn("personTopic");
        when(consumerRecord.value()).thenReturn(new PersonAvro());


        notificationService.read(consumerRecord);


    }

    @Test
    void testConsumeOrder() {
        // Mock a ConsumerRecord for Order
        ConsumerRecord<String, Order> consumerRecord = mock(ConsumerRecord.class);
        when(consumerRecord.topic()).thenReturn("demoTopic");
        when(consumerRecord.value()).thenReturn(new Order());


        notificationService.consume(consumerRecord);


    }

    @Test
    void testConsumeStringPerson() {
        // Mock a ConsumerRecord for String
        ConsumerRecord<String, String> consumerRecord = mock(ConsumerRecord.class);
        when(consumerRecord.topic()).thenReturn("stringTopic");
        when(consumerRecord.value()).thenReturn("test string");


        // Call the method
        notificationService.consumeStringPerson(consumerRecord);


    }

    @Test
    void testConsumeJsonPerson() {
        // Mock a ConsumerRecord for Person
        ConsumerRecord<String, Person> consumerRecord = mock(ConsumerRecord.class);
        when(consumerRecord.topic()).thenReturn("jsonTopic");
        when(consumerRecord.value()).thenReturn(new Person( "Mostafa" , 33 ));



        // Call the method
        notificationService.consumeJsonPerson(consumerRecord);


    }
}