package com.trip.outboxservice.domain.outbox.service;

import com.trip.outboxservice.domain.outbox.dto.MemberListResponse;
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
    public List<MemberListResponse> findAll() {
        return repository.findAll().stream()
                .map(outBox -> new MemberListResponse(outBox.getId(), outBox.getMemberId(), outBox.getPayload()))
                .collect(Collectors.toList());
    }
}
