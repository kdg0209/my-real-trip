package com.trip.couponservice.domain.coupon.adapter.out.persistence.coupon;

import com.trip.couponservice.domain.coupon.application.port.out.CouponCreatePort;
import com.trip.couponservice.domain.coupon.domain.Coupon;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponPersistenceAdapter implements CouponCreatePort {

    private final CouponMapper mapper;
    private final CouponPersistenceDao dao;

    @Override
    public Coupon create(Coupon coupon) {
        var entity = mapper.toEntity(coupon);
        var savedEntity = dao.save(entity);

        return mapper.toDomain(savedEntity);
    }
}
