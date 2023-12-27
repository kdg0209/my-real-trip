package com.trip.couponservice.domain.coupon.adapter.out.persistence.coupon;

import com.trip.couponservice.domain.coupon.repository.CouponRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
class CouponPersistenceDao {

    private final CouponRepository repository;

    public CouponEntity save(CouponEntity entity) {
        return repository.save(entity);
    }
}
