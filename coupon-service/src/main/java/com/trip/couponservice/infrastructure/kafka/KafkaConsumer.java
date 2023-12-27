package com.trip.couponservice.infrastructure.kafka;

import com.trip.couponservice.domain.coupon.application.port.in.CouponCreateUsecase;
import com.trip.couponservice.domain.coupon.dto.request.CouponCreateRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaConsumer {

    private final CouponCreateUsecase createPort;

    @KafkaListener(topics = "outbox")
    public void consume(MemberOutboxMessage message) {
        log.info("Consumer message : {}", message);

        var request = new CouponCreateRequest(message.outBoxId(), message.id());
        createPort.create(request);
    }
}
