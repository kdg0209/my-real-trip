package com.trip.authservice.member.application.port.in;

import com.trip.authservice.member.dto.request.MemberCreateRequest;
import com.trip.authservice.member.dto.response.MemberCreateResponse;

public interface CreateMemberUsecase {

    MemberCreateResponse create(MemberCreateRequest request);
}
