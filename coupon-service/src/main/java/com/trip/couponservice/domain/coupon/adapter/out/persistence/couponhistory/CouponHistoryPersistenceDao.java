package com.trip.couponservice.domain.coupon.adapter.out.persistence.couponhistory;

import com.trip.couponservice.domain.coupon.repository.CouponHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
class CouponHistoryPersistenceDao {

    private final CouponHistoryRepository historyRepository;

    public void save(CouponHistoryEntity entity) {
        historyRepository.save(entity);
    }
}
