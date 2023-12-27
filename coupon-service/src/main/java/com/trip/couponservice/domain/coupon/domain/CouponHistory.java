package com.trip.couponservice.domain.coupon.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CouponHistory {

    private final Long id;
    private final Long couponId;
    private final Long couponOutboxId;
    private final String memberId;
    private final LocalDateTime createDatetime;

    @Builder
    private CouponHistory(Long id, Long couponId, Long couponOutboxId, String memberId, LocalDateTime createDatetime) {
        this.id = id;
        this.couponId = couponId;
        this.couponOutboxId = couponOutboxId;
        this.memberId = memberId;
        this.createDatetime = createDatetime;
    }

    public static CouponHistory create(Long couponId, Long couponOutboxId, String memberId, LocalDateTime createDatetime) {
        return CouponHistory.builder()
                .couponId(couponId)
                .couponOutboxId(couponOutboxId)
                .memberId(memberId)
                .createDatetime(createDatetime)
                .build();
    }
}
