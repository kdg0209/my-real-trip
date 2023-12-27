package com.trip.couponservice.domain.coupon.domain;

import java.util.Arrays;

public enum CouponStatus {

    AVAILABLE("사용 가능한 쿠폰 상태"),
    USED("사용한 쿠폰 상태");

    private final String description;

    CouponStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static CouponStatus findStatus(String status) {
        return Arrays.stream(values())
                .filter(couponStatus -> couponStatus.isEquals(status))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isEquals(String status) {
        return this.name().equals(status);
    }
}
