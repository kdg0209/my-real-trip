package com.trip.outboxservice.domain.outbox.service.port;

import com.trip.outboxservice.domain.outbox.dto.MemberOutboxResponse;

import java.util.List;

public interface MemberFindPort {

    List<MemberOutboxResponse> findAll();
}
