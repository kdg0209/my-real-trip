package com.trip.authservice.outbox.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberOutBox {

    private Long pk;
    private String memberId;
    private String payload;
    private LocalDateTime createDatetime;

    @Builder
    private MemberOutBox(Long pk, String memberId, String payload, LocalDateTime createDatetime) {
        this.pk = pk;
        this.memberId = memberId;
        this.payload = payload;
        this.createDatetime = createDatetime;
    }

    public static MemberOutBox create(String memberId, String payload) {
        return MemberOutBox.builder()
                .memberId(memberId)
                .payload(payload)
                .createDatetime(LocalDateTime.now())
                .build();
    }
}
