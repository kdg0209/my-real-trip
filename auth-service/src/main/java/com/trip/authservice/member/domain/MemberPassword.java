package com.trip.authservice.member.domain;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;

public class MemberPassword {

    private String password;

    public MemberPassword(String password, PasswordEncoder encoder) {
        setPassword(password, encoder);
    }

    public String toString() {
        return this.password;
    }

    private void setPassword(String password, PasswordEncoder encoder) {
        if (!StringUtils.hasText(password)) {
            throw new IllegalArgumentException("NULL 또는 빈공백을 입력할 수 없습니다.");
        }

        if (encoder == null) {
            throw new IllegalStateException("정상적인 상태가 아닙니다.");
        }
        this.password = encoder.encode(password);
    }
}
