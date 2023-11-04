package com.trip.authservice.member.adapter.out.persistence;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.trip.authservice.member.application.port.out.CreateMemberPort;
import com.trip.authservice.member.application.port.out.ValidationMemberPort;
import com.trip.authservice.member.domain.Member;
import com.trip.authservice.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import static com.trip.authservice.member.adapter.out.persistence.QMemberEntity.memberEntity;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements CreateMemberPort, ValidationMemberPort {

    private final JPAQueryFactory queryFactory;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    @Override
    public Member createMember(Member member) {
        var memberEntity = memberMapper.toEntity(member);
        var entity = memberRepository.save(memberEntity);

        return memberMapper.toDomain(entity);
    }

    @Override
    public void validateMemberId(String id) {
        var result = queryFactory
                .selectOne()
                .from(memberEntity)
                .where(
                        eqId(id)
                )
                .fetchFirst();

        if (result != null) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }
    }

    @Override
    public void validateMemberEmail(String email) {
        var result = queryFactory
                .selectOne()
                .from(memberEntity)
                .where(
                        eqEmail(email)
                )
                .fetchFirst();

        if (result != null) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
    }

    private BooleanExpression eqId(String id) {
        return StringUtils.hasText(id) ? memberEntity.id.eq(id) : null;
    }

    private BooleanExpression eqEmail(String email) {
        return StringUtils.hasText(email) ? memberEntity.email.eq(email) : null;
    }
}
