package com.example.kafkademo.service;

import static com.example.kafkademo.constant.ServiceConstant.SIMULATING_SLEEP_MS;

import com.example.kafkademo.model.generated.Order;
import com.example.kafkademo.constant.KafkaConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Order avro service.
 */
@Service
public class OrderAvroService implements KafkaMessageServiceSync {
    private final KafkaTemplate<String, Order> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(OrderAvroService.class);

    /**
     * Instantiates a new Order avro service.
     *
     * @param kafkaTemplate the kafka template
     */
    public OrderAvroService(KafkaTemplate<String, Order> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendKafkaEventSync(Object value) throws InterruptedException {
        kafkaTemplate.send(KafkaConstant.DEMO_TOPIC, (Order) value);
        Thread.sleep(SIMULATING_SLEEP_MS);

    }


}
