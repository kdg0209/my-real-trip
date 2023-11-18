package com.trip.authservice.member.adapter.out.persistence;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "member")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberEntity {

    @Id
    @Tsid
    private Long pk;

    @Comment(value = "아이디")
    @Column(name = "id", length = 50, unique = true, updatable = false)
    private String id;

    @Comment(value = "비밀번호")
    @Column(name = "password")
    private String password;

    @Comment(value = "이름")
    @Column(name = "name", length = 100)
    private String name;

    @Comment(value = "닉네임")
    @Column(name = "nick_name", length = 100)
    private String nickName;

    @Comment(value = "이메일")
    @Column(name = "email", length = 100)
    private String email;

    @Comment(value = "생성일자")
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;

    @Builder
    public MemberEntity(String id, String password, String name, String nickName, String email, LocalDateTime createDatetime) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.createDatetime = createDatetime;
    }

    public void updatePassword(String password) {
        this.password = password;
    }
}
