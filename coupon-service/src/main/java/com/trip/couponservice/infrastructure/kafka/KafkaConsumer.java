package com.trip.couponservice.infrastructure.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumer {

    @KafkaListener(topics = "outbox")
    public void consume(MemberOutboxResponse message) {
        System.out.println("Consumer message : " + message);
    }
}
