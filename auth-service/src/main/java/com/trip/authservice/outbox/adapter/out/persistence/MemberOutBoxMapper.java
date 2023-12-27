package com.trip.authservice.outbox.adapter.out.persistence;

import com.trip.authservice.outbox.domain.MemberOutBox;
import com.trip.authservice.outbox.domain.OutBoxStatus;
import org.springframework.stereotype.Component;

@Component
public class MemberOutBoxMapper {

    public MemberOutBoxEntity toEntity(MemberOutBox memberOutBox) {
        return MemberOutBoxEntity.builder()
                .id(memberOutBox.getId())
                .memberId(memberOutBox.getMemberId())
                .status(memberOutBox.getStatus())
                .payload(memberOutBox.getPayload())
                .createDatetime(memberOutBox.getCreateDatetime())
                .build();
    }
}
