package com.trip.authservice.member.service;

import com.trip.authservice.member.application.port.in.CreateMemberUsecase;
import com.trip.authservice.member.application.port.out.CreateMemberPort;
import com.trip.authservice.member.application.port.out.ValidationMemberPort;
import com.trip.authservice.member.domain.Member;
import com.trip.authservice.member.domain.MemberEmail;
import com.trip.authservice.member.dto.event.MemberCreatedEvent;
import com.trip.authservice.member.dto.request.MemberCreateRequest;
import com.trip.authservice.member.dto.response.MemberCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CreateMemberService implements CreateMemberUsecase {

    private final CreateMemberPort createMemberPort;
    private final ValidationMemberPort validationPort;
    private final ApplicationEventPublisher publisher;

    @Override
    public MemberCreateResponse create(MemberCreateRequest request) {
        validationPort.validateMemberId(request.id());
        validationPort.validateMemberEmail(request.email());

        var memberEmail = new MemberEmail(request.email());
        var member = Member.create(request.id(), request.password(), request.name(), request.nickName(), memberEmail);
        var entity = createMemberPort.createMember(member);

        // 멤버 생성 이벤트 발행
        publisher.publishEvent(new MemberCreatedEvent(member.getId(), member.getName(), member.getEmail()));

        return new MemberCreateResponse(entity.converterPKToString());
    }
}
