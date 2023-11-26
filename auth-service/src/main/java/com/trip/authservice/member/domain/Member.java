package com.trip.authservice.member.domain;

import com.trip.authservice.global.exception.types.InValidException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;

import static com.trip.authservice.global.exception.ErrorCode.ERR_NOT_A_VALID_PASSWORD_FORMAT;

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
        this.name = name;
        this.nickName = nickName;
        this.email = email;
        this.createDatetime = createDatetime;
        setPassword(password);
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

    public String converterPKToString() {
        return String.valueOf(this.pk);
    }

    public String getEmail() {
        return this.email.toString();
    }

    public void updatePassword(String password) {
        setPassword(password);
    }

    private void setPassword(String password) {
        if (!StringUtils.hasText(password)) {
            throw new InValidException(ERR_NOT_A_VALID_PASSWORD_FORMAT);
        }
        this.password = password;
    }
}
