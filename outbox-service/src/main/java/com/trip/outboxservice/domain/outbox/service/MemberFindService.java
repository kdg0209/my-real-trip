package com.trip.outboxservice.domain.outbox.service;

import com.trip.outboxservice.domain.outbox.dao.MemberOutBoxDao;
import com.trip.outboxservice.domain.outbox.domain.MemberOutBox;
import com.trip.outboxservice.domain.outbox.dto.MemberOutboxResponse;
import com.trip.outboxservice.domain.outbox.service.port.MemberFindPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberFindService implements MemberFindPort {

    private final MemberOutBoxDao memberOutBoxDao;

    @Override
    public List<MemberOutboxResponse> findAll() {
        var memberOutBoxes = memberOutBoxDao.findAll();

        // 상태 변경
        memberOutBoxes.forEach(MemberOutBox::updateToDoneStatus);

        return memberOutBoxes.stream()
                .map(outBox -> new MemberOutboxResponse(outBox.getId(), outBox.getMemberId(), outBox.getPayload()))
                .collect(Collectors.toList());
    }
}
