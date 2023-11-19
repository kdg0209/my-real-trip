package com.trip.authservice.member.dto.request;

import jakarta.validation.constraints.NotBlank;

public record MemberUpdatePasswordRequest(@NotBlank String id, @NotBlank String password) {
}
