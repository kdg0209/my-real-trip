package com.trip.couponservice.domain.coupon.application.port.in;

import com.trip.couponservice.domain.coupon.dto.request.CouponCreateRequest;

public interface CouponCreateUsecase {

    void create(CouponCreateRequest request);
}
