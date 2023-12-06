package com.trip.authservice.member.adapter.out.event;

import com.trip.authservice.member.dto.event.MemberCreatedEvent;
import com.trip.authservice.outbox.service.MemberOutBoxCreateService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberEventListener {

    private final MemberOutBoxCreateService service;

    @EventListener(MemberCreatedEvent.class)
    public void handle(MemberCreatedEvent event) {
        service.create(event);
    }
}
