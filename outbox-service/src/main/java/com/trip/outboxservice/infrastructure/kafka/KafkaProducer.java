package com.trip.outboxservice.infrastructure.kafka;

import com.trip.outboxservice.domain.outbox.dto.OutboxMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "outbox";
    private final KafkaTemplate<String, OutboxMessage> kafkaTemplate;

    public void sendMessage(OutboxMessage message) {
        System.out.println("Produce message : " + message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
