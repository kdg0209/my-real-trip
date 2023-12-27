package com.trip.couponservice.infrastructure.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class MemberOutboxMessageDeserializer implements Deserializer<MemberOutboxMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // Nothing to configure
    }

    @Override
    public MemberOutboxMessage deserialize(String topic, byte[] data) {
        try {
            // Convert the byte array to a String representation of JSON and then parse it into GiftRequest object
            return objectMapper.reader().readValue(data, MemberOutboxMessage.class);
        } catch (Exception e) {
            // Handle any deserialization errors here
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void close() {
        // Nothing to close
    }
}
