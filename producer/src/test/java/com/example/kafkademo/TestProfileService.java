package com.example.kafkademo;

import com.example.kafkademo.model.Person;
import com.example.kafkademo.service.ProfileService;
import com.example.kafkademo.constant.KafkaConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TestProfileService {

    @Mock
    private KafkaTemplate<Integer, Person> kafkaTemplate;

    private ProfileService profileService ;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        profileService = new ProfileService(kafkaTemplate);
    }

    @Test
    public void testSendProfileSync(){

        Person  person = new Person("Mostafa" , 33  ) ;


        profileService.sendPersonDetailsAsync(person) ;

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.JSON_TOPIC), eq(person));

    }

    @Test
    public void testSendProfileAsync(){

        Person  person = new Person("Mostafa" , 33  ) ;


        CompletableFuture<SendResult<Integer, Person>> future = new CompletableFuture<>();
        SendResult<Integer, Person> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaConstant.PERSON_TOPIC), eq(person))).thenReturn(future);

        profileService.sendPersonDetailsAsync(person) ;

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.JSON_TOPIC), eq(person));

    }


}
