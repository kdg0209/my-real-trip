package com.trip.authservice.global.exception.types;

import com.trip.authservice.global.exception.ErrorCode;

public class InValidException extends RuntimeException {

    private final ErrorCode errorCode;

    public InValidException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
