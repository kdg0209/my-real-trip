package com.trip.authservice.outbox.adapter.out.persistence;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "member_outbox")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberOutBoxEntity {

    @Id
    @Tsid
    private Long id;

    @Comment(value = "멤버 아이디")
    @Column(name = "member_id", length = 50, unique = true, updatable = false)
    private String memberId;

    @Comment(value = "아웃박스 상태")
    @Column(name = "status", length = 50, nullable = false)
    private String status;

    @Comment(value = "payload")
    @Column(name = "payload", columnDefinition = "TEXT", unique = true, updatable = false)
    private String payload;

    @Comment(value = "생성일자")
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;

    @Builder
    public MemberOutBoxEntity(Long id, String memberId, String status, String payload, LocalDateTime createDatetime) {
        this.id = id;
        this.memberId = memberId;
        this.status = status;
        this.payload = payload;
        this.createDatetime = createDatetime;
    }
}
