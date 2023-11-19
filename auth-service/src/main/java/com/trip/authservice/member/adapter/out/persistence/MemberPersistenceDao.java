package com.trip.authservice.member.adapter.out.persistence;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.authservice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Optional;

import static com.trip.authservice.member.adapter.out.persistence.QMemberEntity.memberEntity;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
class MemberPersistenceDao {

    private final JPAQueryFactory queryFactory;
    private final MemberRepository memberRepository;

    MemberEntity save(MemberEntity entity) {
        return memberRepository.save(entity);
    }

    Optional<MemberEntity> findById(String id) {
        var result = queryFactory
                .selectFrom(memberEntity)
                .where(
                        eqId(id)
                )
                .fetchFirst();

        return Optional.ofNullable(result);
    }

    Optional<MemberEntity> findByEmail(String email) {
        var result = queryFactory
                .selectFrom(memberEntity)
                .where(
                        eqEmail(email)
                )
                .fetchFirst();

        return Optional.ofNullable(result);
    }

    private BooleanExpression eqId(String id) {
        return StringUtils.hasText(id) ? memberEntity.id.eq(id) : null;
    }

    private BooleanExpression eqEmail(String email) {
        return StringUtils.hasText(email) ? memberEntity.email.eq(email) : null;
    }
}
