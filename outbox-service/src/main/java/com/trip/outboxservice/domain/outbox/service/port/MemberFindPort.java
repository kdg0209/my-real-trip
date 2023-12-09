package com.trip.outboxservice.domain.outbox.service.port;

import com.trip.outboxservice.domain.outbox.dto.MemberListResponse;

import java.util.List;

public interface MemberFindPort {

    List<MemberListResponse> findAll();
}
