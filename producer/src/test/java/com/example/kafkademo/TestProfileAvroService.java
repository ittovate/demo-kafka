package com.example.kafkademo;

import com.example.kafkademo.model.generated.PersonAvro;
import com.example.kafkademo.service.ProfileAvroService;
import com.example.kafkademo.constant.KafkaConstant;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
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

        when(kafkaTemplate.send(eq(KafkaConstant.PERSON_TOPIC), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.PERSON_TOPIC), eq(person));
    }

    @Test
    public void testSendKafkaEventWithoutAge() throws Exception {
        PersonAvro person = PersonAvro.newBuilder()
                .setName("Mostafa")
                .build();

        CompletableFuture<SendResult<String, PersonAvro>> future = new CompletableFuture<>();
        SendResult<String, PersonAvro> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaConstant.PERSON_TOPIC), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.PERSON_TOPIC), eq(person));
    }

    @Test
    public void testSendKafkaEventWithoutName() throws Exception {
        PersonAvro person = PersonAvro.newBuilder()
                .setAge(30)
                .build();

        CompletableFuture<SendResult<String, PersonAvro>> future = new CompletableFuture<>();
        SendResult<String, PersonAvro> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaConstant.PERSON_TOPIC), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.PERSON_TOPIC), eq(person));
    }

    @Test
    public void testSendKafkaEventWithoutDataAvro() throws Exception {
        PersonAvro person = PersonAvro.newBuilder()
                .build();

        CompletableFuture<SendResult<String, PersonAvro>> future = new CompletableFuture<>();
        SendResult<String, PersonAvro> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaConstant.PERSON_TOPIC), eq(person))).thenReturn(future);

        profileAvroService.sendKafkaEventSync(person );

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.PERSON_TOPIC), eq(person));
    }
}