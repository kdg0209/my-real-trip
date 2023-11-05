package com.trip.authservice.member.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Member {

    private Long pk;
    private String id;
    private String password;
    private String name;
    private String nickName;
    private MemberEmail email;
    private LocalDateTime createDatetime;

    @Builder
    private Member(Long pk, String id, String password, String name, String nickName, MemberEmail email, LocalDateTime createDatetime) {
        this.pk = pk;
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.createDatetime = createDatetime;
    }

    public static Member domain(Long pk, String id, String password, String name, String nickName, MemberEmail email, LocalDateTime createDatetime) {
        return Member.builder()
                .pk(pk)
                .id(id)
                .password(password)
                .name(name)
                .nickName(nickName)
                .email(email)
                .createDatetime(createDatetime)
                .build();
    }

    public static Member create(String id, String password, String name, String nickName, MemberEmail email) {
        return Member.builder()
                .id(id)
                .password(password)
                .name(name)
                .nickName(nickName)
                .email(email)
                .createDatetime(LocalDateTime.now())
                .build();
    }

    public String getPk() {
        return String.valueOf(pk);
    }

    public String getEmail() {
        return this.email.toString();
    }
}
