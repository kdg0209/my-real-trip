package com.trip.outboxservice.infrastructure.scheduler;

import com.trip.outboxservice.domain.outbox.service.port.MemberFindPort;
import com.trip.outboxservice.infrastructure.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Slf4j
@Component
@RequiredArgsConstructor
public class OutBoxScheduler {

    private final MemberFindPort findPort;
    private final KafkaProducer kafkaProducer;

    @Scheduled(cron = "0/10 * * * * *")
    public void scheduler() {
        findPort.findAll()
                .forEach(kafkaProducer::sendMessage);
    }
}
