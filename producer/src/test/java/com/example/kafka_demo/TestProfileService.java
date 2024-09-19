package com.example.kafka_demo;

import com.example.kafka_demo.model.Person;
import com.example.kafka_demo.model.generated.PersonAvro;
import com.example.kafka_demo.service.OrderService;
import com.example.kafka_demo.service.ProfileService;
import com.example.kafka_demo.util.KafkaUtils;
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

        verify(kafkaTemplate, times(1)).send(eq(KafkaUtils.JsonTopic), eq(person));

    }

    @Test
    public void testSendProfileAsync(){

        Person  person = new Person("Mostafa" , 33  ) ;


        CompletableFuture<SendResult<Integer, Person>> future = new CompletableFuture<>();
        SendResult<Integer, Person> sendResult = mock(SendResult.class);
        future.complete(sendResult);

        when(kafkaTemplate.send(eq(KafkaUtils.personTopic), eq(person))).thenReturn(future);

        profileService.sendPersonDetailsAsync(person) ;

        verify(kafkaTemplate, times(1)).send(eq(KafkaUtils.JsonTopic), eq(person));

    }


}
