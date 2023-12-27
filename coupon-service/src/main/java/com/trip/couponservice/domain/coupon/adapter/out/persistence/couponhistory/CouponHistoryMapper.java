package com.trip.couponservice.domain.coupon.adapter.out.persistence.couponhistory;

import com.trip.couponservice.domain.coupon.domain.CouponHistory;
import org.springframework.stereotype.Component;

@Component
public class CouponHistoryMapper {

    public CouponHistoryEntity toEntity(CouponHistory couponHistory) {
        return CouponHistoryEntity.builder()
                .id(couponHistory.getId())
                .couponId(couponHistory.getCouponId())
                .memberId(couponHistory.getMemberId())
                .couponOutboxId(couponHistory.getCouponOutboxId())
                .createDatetime(couponHistory.getCreateDatetime())
                .build();
    }
}
