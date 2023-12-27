package com.trip.couponservice.domain.coupon.adapter.out.persistence.couponhistory;

import com.trip.couponservice.domain.coupon.application.port.out.CouponHistoryCreatePort;
import com.trip.couponservice.domain.coupon.domain.CouponHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CouponHistoryPersistenceAdapter implements CouponHistoryCreatePort {

    private final CouponHistoryMapper historyMapper;
    private final CouponHistoryPersistenceDao historyDao;

    @Override
    public void create(CouponHistory couponHistory) {
        var entity = historyMapper.toEntity(couponHistory);
        historyDao.save(entity);
    }
}
