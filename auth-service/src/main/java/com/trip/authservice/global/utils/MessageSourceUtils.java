package com.trip.authservice.global.utils;

import com.trip.authservice.global.exception.ErrorCode;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceUtils {

    @Resource
    private MessageSource source;

    static MessageSource messageSource;

    @PostConstruct
    public void initialize() {
        messageSource = source;
    }

    public static String getMessage(ErrorCode errorCode) {
        return messageSource.getMessage(errorCode.getCode(), null, LocaleContextHolder.getLocale());
    }
}
