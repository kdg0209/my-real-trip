package com.trip.couponservice.domain.coupon.repository;

import com.trip.couponservice.domain.coupon.adapter.out.persistence.coupon.CouponEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<CouponEntity, Long> {
}
