package com.trip.outboxservice.infrastructure.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trip.outboxservice.domain.outbox.dto.OutboxMessage;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class OutboxMessageSerializer implements Serializer<OutboxMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Nothing to configure
    }

    @Override
    public byte[] serialize(String topic, OutboxMessage data) {
        try {
            return objectMapper.writeValueAsBytes(data);
        } catch (Exception e) {
            throw new IllegalArgumentException("해당 data를 직렬화 수 없습니다." + data);
        }
    }

    @Override
    public void close() {
        // Nothing to close
    }
}
