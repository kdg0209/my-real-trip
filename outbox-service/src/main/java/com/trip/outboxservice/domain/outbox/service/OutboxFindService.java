package com.trip.outboxservice.domain.outbox.service;

import com.trip.outboxservice.domain.outbox.dao.MemberOutBoxDao;
import com.trip.outboxservice.domain.outbox.domain.MemberOutBox;
import com.trip.outboxservice.domain.outbox.dto.OutboxMessage;
import com.trip.outboxservice.domain.outbox.service.port.OutboxFindPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OutboxFindService implements OutboxFindPort {

    private final MemberOutBoxDao memberOutBoxDao;

    @Override
    public List<OutboxMessage> findAll() {
        var outBoxes = memberOutBoxDao.findAll();

        // 상태 변경
        outBoxes.forEach(MemberOutBox::updateToDoneStatus);

        return outBoxes.stream()
                .map(outBox -> new OutboxMessage(outBox.getId(), outBox.getMemberId(), outBox.getPayload()))
                .collect(Collectors.toList());
    }
}
