package com.trip.couponservice.domain.coupon.application.port.out;

import com.trip.couponservice.domain.coupon.domain.Coupon;

public interface CouponCreatePort {

    Coupon create(Coupon coupon);
}
