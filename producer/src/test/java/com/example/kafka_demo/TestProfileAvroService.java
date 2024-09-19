package com.example.kafka_demo;

import com.example.kafka_demo.model.generated.Order;
import com.example.kafka_demo.model.generated.PersonAvro;
import com.example.kafka_demo.service.OrderAvroService;
import com.example.kafka_demo.service.ProfileAvroService;
import com.example.kafka_demo.util.KafkaUtils;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

@SpringBootTest
public class TestProfileAvroService {

    @Mock
    private KafkaTemplate<String, PersonAvro> kafkaTemplate;


    private ProfileAvroService profileAvroService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        profileAvroService = new ProfileAvroService(kafkaTemplate) ;
    }
    @Test
    public void testSendKafkaEventSyncAvro() throws Exception {
        PersonAvro person = PersonAvro.newBuilder()
                .setAge(30)
                .setName("Mostafa")
                .build();

        CompletableFuture<SendResult<String, PersonAvro>> future = new CompletableFuture<>();
        SendResult<String, PersonAvro> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaUtils.personTopic), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaUtils.personTopic), eq(person));
    }

    @Test
    public void testSendKafkaEventWithoutAge() throws Exception {
        PersonAvro person = PersonAvro.newBuilder()
                .setName("Mostafa")
                .build();

        CompletableFuture<SendResult<String, PersonAvro>> future = new CompletableFuture<>();
        SendResult<String, PersonAvro> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaUtils.personTopic), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaUtils.personTopic), eq(person));
    }

    @Test
    public void testSendKafkaEventWithoutName() throws Exception {
        PersonAvro person = PersonAvro.newBuilder()
                .setAge(30)
                .build();

        CompletableFuture<SendResult<String, PersonAvro>> future = new CompletableFuture<>();
        SendResult<String, PersonAvro> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaUtils.personTopic), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaUtils.personTopic), eq(person));
    }

    @Test
    public void testSendKafkaEventWithoutDataAvro() throws Exception {
        PersonAvro person = PersonAvro.newBuilder()
                .build();

        CompletableFuture<SendResult<String, PersonAvro>> future = new CompletableFuture<>();
        SendResult<String, PersonAvro> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaUtils.personTopic), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaUtils.personTopic), eq(person));
    }
}