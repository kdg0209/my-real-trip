package com.trip.outboxservice.domain.outbox.domain;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Comment(value = "payload")
    @Column(name = "payload", columnDefinition = "TEXT", unique = true, updatable = false)
    private String payload;

    @Comment(value = "생성일자")
    @Column(name = "create_datetime")
    private LocalDateTime createDatetime;
}
