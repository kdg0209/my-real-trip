package com.trip.authservice.outbox.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberOutBox {

    private Long id;
    private String memberId;
    private OutBoxStatus status;
    private String payload;
    private LocalDateTime createDatetime;

    @Builder
    private MemberOutBox(Long id, String memberId, OutBoxStatus status, String payload, LocalDateTime createDatetime) {
        this.id = id;
        this.memberId = memberId;
        this.status = status;
        this.payload = payload;
        this.createDatetime = createDatetime;
    }

    public static MemberOutBox create(String memberId, String payload) {
        return MemberOutBox.builder()
                .memberId(memberId)
                .status(OutBoxStatus.READY)
                .payload(payload)
                .createDatetime(LocalDateTime.now())
                .build();
    }

    public String getStatus() {
        return this.status.name();
    }
}
