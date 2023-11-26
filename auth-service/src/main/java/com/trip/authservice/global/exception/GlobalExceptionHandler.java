package com.trip.authservice.global.exception;

import com.trip.authservice.global.exception.types.BusinessException;
import com.trip.authservice.global.exception.types.EntityNotFoundException;
import com.trip.authservice.global.exception.types.InValidException;
import com.trip.authservice.global.utils.MessageSourceUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InValidException.class)
    public ErrorResponse handle(InValidException e) {
        var message = MessageSourceUtils.getMessage(e.getErrorCode());
        return new ErrorResponse(message);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ErrorResponse handle(EntityNotFoundException e) {
        var message = MessageSourceUtils.getMessage(e.getErrorCode());
        return new ErrorResponse(message);
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(BusinessException.class)
    public ErrorResponse handle(BusinessException e) {
        var message = MessageSourceUtils.getMessage(e.getErrorCode());
        return new ErrorResponse(message);
    }
}
