package com.trip.authservice.member.dto.event;

public record MemberCreatedEvent(String id, String name, String email) {
}
