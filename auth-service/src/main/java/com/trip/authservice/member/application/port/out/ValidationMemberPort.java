package com.trip.authservice.member.application.port.out;

public interface ValidationMemberPort {

    void validateMemberId(String id);
    void validateMemberEmail(String email);
}
