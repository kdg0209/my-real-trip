package com.trip.authservice.global.exception.types;

import com.trip.authservice.global.exception.ErrorCode;

public class EntityNotFoundException extends RuntimeException {

    private final ErrorCode errorCode;

    public EntityNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
