package com.trip.outboxservice.domain.outbox.dao;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.outboxservice.domain.outbox.domain.MemberOutBox;
import com.trip.outboxservice.domain.outbox.domain.OutBoxStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.trip.outboxservice.domain.outbox.domain.QMemberOutBox.memberOutBox;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberOutBoxDao {

    private final JPAQueryFactory queryFactory;

    public List<MemberOutBox> findAll() {
        return queryFactory
                .selectFrom(memberOutBox)
                .where(
                        memberOutBox.status.eq(OutBoxStatus.READY)
                )
                .fetch();
    }
}
