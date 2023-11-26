package com.trip.authservice.member.domain;

import com.trip.authservice.global.exception.types.InValidException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.trip.authservice.global.exception.ErrorCode.ERR_NOT_A_VALID_EMAIL_FORMAT;

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
            throw new InValidException(ERR_NOT_A_VALID_EMAIL_FORMAT);
        }
        this.email = email;
    }
}
