package com.trip.authservice.outbox.adapter.out.persistence;

import com.trip.authservice.outbox.application.port.out.CreateMemberOutBoxPort;
import com.trip.authservice.outbox.domain.MemberOutBox;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberOutBoxPersistenceAdapter implements CreateMemberOutBoxPort {

    private final MemberOutBoxMapper mapper;
    private final MemberOutBoxDao memberOutBoxDao;

    @Override
    public void createMemberOutBox(MemberOutBox memberOutBox) {
        var entity = mapper.toEntity(memberOutBox);
        memberOutBoxDao.save(entity);
    }
}
