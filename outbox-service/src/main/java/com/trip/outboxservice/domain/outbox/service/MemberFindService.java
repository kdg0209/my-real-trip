package com.trip.outboxservice.domain.outbox.service;

import com.trip.outboxservice.domain.outbox.dto.MemberOutboxResponse;
import com.trip.outboxservice.domain.outbox.repository.MemberOutBoxRepository;
import com.trip.outboxservice.domain.outbox.service.port.MemberFindPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberFindService implements MemberFindPort {

    private final MemberOutBoxRepository repository;

    @Override
    public List<MemberOutboxResponse> findAll() {
        return repository.findAll().stream()
                .map(outBox -> new MemberOutboxResponse(outBox.getId(), outBox.getMemberId(), outBox.getPayload()))
                .collect(Collectors.toList());
    }
}
