package com.trip.couponservice.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "outbox", containerFactory = "kafkaListenerContainerFactory")
    public void consume(String message) {
        System.out.println("Consumer message : " + message);
    }
}
