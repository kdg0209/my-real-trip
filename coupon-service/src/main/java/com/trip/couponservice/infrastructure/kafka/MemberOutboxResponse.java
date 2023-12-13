package com.trip.couponservice.infrastructure.kafka;

public record MemberOutboxResponse(Long outBoxId, String id, String payload) {
}
