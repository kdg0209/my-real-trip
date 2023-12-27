package com.trip.outboxservice.domain.outbox.domain;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "member_outbox")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberOutBox {

    @Id
    @Tsid
    private Long id;

    @Comment(value = "멤버 아이디")
    @Column(name = "member_id", length = 50, unique = true, updatable = false)
    private String memberId;

    @Enumerated(EnumType.STRING)
    @Comment(value = "아웃박스 상태")
    @Column(name = "status", length = 50, nullable = false)
    private OutBoxStatus status;

    @Comment(value = "payload")
    @Column(name = "payload", columnDefinition = "TEXT", unique = true, updatable = false)
    private String payload;

    @Comment(value = "생성일자")
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;

    public void updateToDoneStatus() {
        this.status = OutBoxStatus.DONE;
    }
}
