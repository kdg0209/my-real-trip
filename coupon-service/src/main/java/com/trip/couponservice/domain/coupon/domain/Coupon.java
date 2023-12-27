package com.trip.couponservice.domain.coupon.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Coupon {

    private final Long id;
    private final String name;
    private final CouponStatus status;
    private final LocalDateTime createDatetime;

    @Builder
    private Coupon(Long id, String name, CouponStatus status, LocalDateTime createDatetime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createDatetime = createDatetime;
    }

    public static Coupon domain(Long id, String name, CouponStatus status, LocalDateTime createDatetime) {
        return Coupon.builder()
                .id(id)
                .name(name)
                .status(status)
                .createDatetime(createDatetime)
                .build();
    }

    public static Coupon create(String name, CouponStatus status, LocalDateTime createDatetime) {
        return Coupon.builder()
                .name(name)
                .status(status)
                .createDatetime(createDatetime)
                .build();
    }

    public String getStatusName() {
        return this.status.name();
    }
}
