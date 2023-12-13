package com.trip.outboxservice.domain.outbox.dto;

public record MemberOutboxResponse(Long outBoxId, String id, String payload) {
}
