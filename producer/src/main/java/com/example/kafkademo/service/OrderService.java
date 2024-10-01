package com.example.kafkademo.service;

import static com.example.kafkademo.constant.ServiceConstant.SIMULATING_SLEEP_MS;

import com.example.kafkademo.constant.KafkaConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * The type Order service.
 */
@Service
public class OrderService implements KafkaMessageServiceSync, KafkaMessageServiceAsync {
    private final KafkaTemplate<Integer, String> kafkaTemplate;
    private final Logger logger = LoggerFactory.getLogger(OrderService.class);

    /**
     * Instantiates a new Order service.
     *
     * @param kafkaTemplate the kafka template
     */
    public OrderService(KafkaTemplate<Integer, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendKafkaEventAsync(Object value) {
        kafkaTemplate.send(KafkaConstant.STRING_TOPIC, (String) value);
    }

    @Override
    public void sendKafkaEventSync(Object value) throws InterruptedException {
        kafkaTemplate.send(KafkaConstant.STRING_TOPIC, (String) value);
        Thread.sleep(SIMULATING_SLEEP_MS);

    }

    /**
     * Make order sync.
     *
     * @param email the email
     * @throws InterruptedException the interrupted exception
     */
    public void makeOrderSync(String email) throws InterruptedException {
        sendKafkaEventSync(email);
    }

    /**
     * Make order async.
     *
     * @param email the email
     */
    public void makeOrderAsync(String email) {
        sendKafkaEventAsync(email);
    }
}
