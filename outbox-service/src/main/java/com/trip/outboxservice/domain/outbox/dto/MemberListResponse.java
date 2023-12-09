package com.trip.outboxservice.domain.outbox.dto;

public record MemberListResponse(Long outBoxId, String id, String payload) {
}
