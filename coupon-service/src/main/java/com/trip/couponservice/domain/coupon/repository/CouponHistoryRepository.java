package com.trip.couponservice.domain.coupon.repository;

import com.trip.couponservice.domain.coupon.adapter.out.persistence.couponhistory.CouponHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponHistoryRepository extends JpaRepository<CouponHistoryEntity, Long> {
}
