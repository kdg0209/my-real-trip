package com.trip.outboxservice.domain.outbox.service.port;

import com.trip.outboxservice.domain.outbox.dto.OutboxMessage;

import java.util.List;

public interface OutboxFindPort {

    List<OutboxMessage> findAll();
}
