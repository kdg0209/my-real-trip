package com.trip.couponservice.domain.coupon.application.port.out;

import com.trip.couponservice.domain.coupon.domain.CouponHistory;

public interface CouponHistoryCreatePort {

    void create(CouponHistory couponHistory);
}
