package com.trip.authservice.member.adapter.out.persistence;

import com.trip.authservice.member.domain.Member;
import com.trip.authservice.member.domain.MemberEmail;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MemberMapper {

    private final PasswordEncoder encoder;

    public Member toDomain(MemberEntity entity) {
        return Member.domain(entity.getPk(),
                entity.getId(),
                entity.getPassword(),
                entity.getName(),
                entity.getNickName(),
                new MemberEmail(entity.getEmail()),
                entity.getCreateDatetime()
        );
    }

    public MemberEntity toEntity(Member member) {
        return MemberEntity.builder()
                .id(member.getId())
                .password(passwordEncoding(member.getPassword()))
                .name(member.getName())
                .nickName(member.getNickName())
                .email(member.getEmail())
                .createDatetime(member.getCreateDatetime())
                .build();
    }

    private String passwordEncoding(String password) {
        return encoder.encode(password);
    }
}
