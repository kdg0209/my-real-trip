package com.trip.couponservice.domain.coupon.service;

import com.trip.couponservice.domain.coupon.application.port.in.CouponCreateUsecase;
import com.trip.couponservice.domain.coupon.application.port.out.CouponCreatePort;
import com.trip.couponservice.domain.coupon.application.port.out.CouponHistoryCreatePort;
import com.trip.couponservice.domain.coupon.domain.Coupon;
import com.trip.couponservice.domain.coupon.domain.CouponHistory;
import com.trip.couponservice.domain.coupon.domain.CouponStatus;
import com.trip.couponservice.domain.coupon.dto.request.CouponCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
@RequiredArgsConstructor
public class CouponCreateService implements CouponCreateUsecase {

    private static final String COUPON_NAME = "가입 축하 쿠폰";

    private final CouponCreatePort createPort;
    private final CouponHistoryCreatePort historyCreatePort;

    @Override
    public void create(CouponCreateRequest request) {

        // 쿠폰 저장
        var coupon = Coupon.create(COUPON_NAME, CouponStatus.AVAILABLE, LocalDateTime.now());
        var savedCoupon = createPort.create(coupon);

        // 쿠폰 히스토리 저장
        var couponHistory = CouponHistory.create(savedCoupon.getId(), request.outBoxId(), request.memberId(), LocalDateTime.now());
        historyCreatePort.create(couponHistory);
    }
}
