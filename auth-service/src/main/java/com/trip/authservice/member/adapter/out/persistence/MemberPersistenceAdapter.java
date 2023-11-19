package com.trip.authservice.member.adapter.out.persistence;

import com.trip.authservice.member.application.port.out.CreateMemberPort;
import com.trip.authservice.member.application.port.out.FindMemberPort;
import com.trip.authservice.member.application.port.out.UpdatePasswordMemberPort;
import com.trip.authservice.member.application.port.out.ValidationMemberPort;
import com.trip.authservice.member.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberPersistenceAdapter implements FindMemberPort, CreateMemberPort, ValidationMemberPort, UpdatePasswordMemberPort {

    private final MemberMapper memberMapper;
    private final MemberPersistenceDao memberPersistenceDao;

    @Override
    public Member findById(String id) {
        var entity = memberPersistenceDao.findById(id)
                .orElseThrow(() -> new IllegalStateException("엔티티가 존재하지 않습니다."));

        return this.memberMapper.toDomain(entity);
    }

    @Override
    public Member createMember(Member member) {
        var memberEntity = memberMapper.toEntity(member);
        var entity = memberPersistenceDao.save(memberEntity);

        return memberMapper.toDomain(entity);
    }

    @Override
    public void updatePassword(Member member) {
        var entity = memberMapper.toEntity(member);
        memberPersistenceDao.save(entity);
    }

    @Override
    public void validateMemberId(String id) {
        var optional = memberPersistenceDao.findById(id);

        optional.ifPresent(entity -> {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        });
    }

    @Override
    public void validateMemberEmail(String email) {
        var optional = memberPersistenceDao.findByEmail(email);

        optional.ifPresent(entity -> {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        });
    }
}
