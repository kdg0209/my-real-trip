package com.trip.outboxservice.infrastructure.kafka;

import com.trip.outboxservice.domain.outbox.dto.MemberOutboxResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer {

    private static final String TOPIC = "outbox";
    private final KafkaTemplate<String, MemberOutboxResponse> kafkaTemplate;

    public void sendMessage(MemberOutboxResponse message) {
        System.out.println("Produce message : " + message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}
