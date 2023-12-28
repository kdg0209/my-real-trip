package com.trip.outboxservice.domain.outbox.dto;

public record OutboxMessage(Long outBoxId, String id, String payload) {
}
