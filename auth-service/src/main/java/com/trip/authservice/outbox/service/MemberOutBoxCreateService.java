package com.trip.authservice.outbox.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trip.authservice.member.dto.event.MemberCreatedEvent;
import com.trip.authservice.outbox.application.port.out.CreateMemberOutBoxPort;
import com.trip.authservice.outbox.domain.MemberOutBox;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberOutBoxCreateService {

    private final CreateMemberOutBoxPort createMemberOutBoxPort;

    @SneakyThrows
    public void create(MemberCreatedEvent event) {
        var objectMapper = new ObjectMapper();
        var payload = objectMapper.writeValueAsString(event);
        var memberOutBox = MemberOutBox.create(event.id(), payload);

        createMemberOutBoxPort.createMemberOutBox(memberOutBox);
    }
}
