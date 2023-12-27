package com.trip.authservice.outbox.adapter.out.persistence;

import com.trip.authservice.outbox.repository.MemberOutBoxRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
class MemberOutBoxDao {

    private final MemberOutBoxRepository memberOutBoxRepository;

    public void save(MemberOutBoxEntity entity) {
        this.memberOutBoxRepository.save(entity);
    }
}
