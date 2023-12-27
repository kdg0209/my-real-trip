package com.trip.couponservice.infrastructure.kafka;

public record MemberOutboxMessage(Long outBoxId, String id, String payload) {
}
