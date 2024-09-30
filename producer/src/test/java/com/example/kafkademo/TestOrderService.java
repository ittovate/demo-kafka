package com.example.kafkademo;


import com.example.kafkademo.service.OrderService;
import com.example.kafkademo.constant.KafkaConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

import static org.mockito.Mockito.*;

@SpringBootTest
public class TestOrderService {

    @Mock
    private KafkaTemplate<Integer, String> kafkaTemplate;

     private OrderService orderService ;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        orderService = new OrderService(kafkaTemplate);
    }

    @Test
    public void testSendKafkaEventSync(){

        String email = "test@example.com" ;

        orderService.makeOrderAsync(email);

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.STRING_TOPIC), eq(email));

    }

    @Test
    public void testMakeOrderSync() throws Exception {


        String email = "test@example.com";
        CompletableFuture<SendResult<Integer, String>> future = new CompletableFuture<>();
        when(kafkaTemplate.send(eq(KafkaConstant.STRING_TOPIC), eq(email))).thenReturn(future);

        orderService.makeOrderSync(email);

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.STRING_TOPIC), eq(email));
    }

}
