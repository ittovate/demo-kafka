package com.example.kafkademo;

import com.example.kafkademo.model.generated.Order;
import com.example.kafkademo.service.OrderAvroService;
import com.example.kafkademo.constant.KafkaConstant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

@SpringBootTest
public class TestOrderAvroService {

    @Mock
    private KafkaTemplate<String, Order> kafkaTemplate;

    private OrderAvroService orderAvroService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        orderAvroService = new OrderAvroService(kafkaTemplate);
    }

    @Test
    public void testSendKafkaEventSync() throws Exception {
        // Create an Order object with test data
        Order testOrder = Order.newBuilder()
                .setCustomerEmail("test@example.com")
                .build();

        // Mock the KafkaTemplate's send method
        CompletableFuture<SendResult<String, Order>> future = new CompletableFuture<>();
        when(kafkaTemplate.send(eq(KafkaConstant.DEMO_TOPIC), any(Order.class))).thenReturn(future);
        future.complete(mock(SendResult.class));

        // Call the method under test
        orderAvroService.sendKafkaEventSync(testOrder);

        verify(kafkaTemplate, times(1)).send(eq(KafkaConstant.DEMO_TOPIC), eq(testOrder));
    }
}