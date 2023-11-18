package com.trip.authservice.member.service;

import com.trip.authservice.member.application.port.in.MemberUpdatePasswordUsecase;
import com.trip.authservice.member.application.port.out.FindMemberPort;
import com.trip.authservice.member.application.port.out.UpdatePasswordMemberPort;
import com.trip.authservice.member.dto.request.MemberUpdatePasswordRequest;
import com.trip.authservice.member.dto.response.MemberUpdatePasswordResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberUpdatePasswordService implements MemberUpdatePasswordUsecase {

    private final FindMemberPort findMemberPort;
    private final UpdatePasswordMemberPort updatePasswordMemberPort;

    @Override
    public MemberUpdatePasswordResponse updatePassword(MemberUpdatePasswordRequest request) {
        var member = findMemberPort.findById(request.id());
        member.updatePassword(request.password());
        updatePasswordMemberPort.updatePassword(member);

        return new MemberUpdatePasswordResponse(member.getId());
    }
}
