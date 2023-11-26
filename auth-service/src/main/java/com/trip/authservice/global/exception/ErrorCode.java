package com.trip.authservice.global.exception;

public enum ErrorCode {

    ERR_NOT_A_VALID_EMAIL_FORMAT("ERR_NOT_A_VALID_EMAIL_FORMAT"),
    ERR_NOT_A_VALID_PASSWORD_FORMAT("ERR_NOT_A_VALID_PASSWORD_FORMAT"),

    ERR_MEMBER_NOT_FOUND("ERR_MEMBER_NOT_FOUND"),
    ERR_MEMBER_ID_ALREADY_EXISTS("ERR_MEMBER_ID_ALREADY_EXISTS"),
    ERR_MEMBER_EMAIL_ALREADY_EXISTS("ERR_MEMBER_EMAIL_ALREADY_EXISTS"),;

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
