package com.trip.authservice.member.application.port.in;

import com.trip.authservice.member.dto.request.MemberUpdatePasswordRequest;
import com.trip.authservice.member.dto.response.MemberUpdatePasswordResponse;

public interface MemberUpdatePasswordUsecase {

    MemberUpdatePasswordResponse updatePassword(MemberUpdatePasswordRequest request);
}
