package com.trip.authservice.member.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record MemberCreateRequest(
        @NotBlank String id,
        @NotBlank String password,
        @NotBlank String name,
        @NotBlank String nickName,
        @NotBlank @Email String email) {
}
