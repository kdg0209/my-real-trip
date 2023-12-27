package com.trip.couponservice.domain.coupon.adapter.out.persistence.coupon;

import com.trip.couponservice.domain.coupon.adapter.out.persistence.coupon.CouponEntity;
import com.trip.couponservice.domain.coupon.domain.Coupon;
import com.trip.couponservice.domain.coupon.domain.CouponStatus;
import org.springframework.stereotype.Component;

@Component
public class CouponMapper {

    public Coupon toDomain(CouponEntity entity) {
        return Coupon.domain(entity.getId(),
                entity.getName(),
                CouponStatus.findStatus(entity.getStatus()),
                entity.getCreateDatetime()
        );
    }

    public CouponEntity toEntity(Coupon coupon) {
        return CouponEntity.builder()
                .id(coupon.getId())
                .name(coupon.getName())
                .status(coupon.getStatusName())
                .createDatetime(coupon.getCreateDatetime())
                .build();
    }
}
