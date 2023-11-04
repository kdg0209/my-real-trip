package com.trip.authservice.member.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberEmail {

    private static final String REGEX = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private String email;

    public MemberEmail(String email) {
        setEmail(email);
    }

    public String toString() {
        return email;
    }

    private void setEmail(String email) {
        Matcher result = PATTERN.matcher(email);

        if (!result.matches()) {
            throw new IllegalArgumentException("잘못된 이메일 형식입니다.");
        }
        this.email = email;
    }
}
