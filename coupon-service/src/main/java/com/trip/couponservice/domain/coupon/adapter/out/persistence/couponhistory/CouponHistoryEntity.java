package com.trip.couponservice.domain.coupon.adapter.out.persistence.couponhistory;

import io.hypersistence.utils.hibernate.id.Tsid;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "coupon_history")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponHistoryEntity {

    @Id
    @Tsid
    private Long id;

    @Comment(value = "쿠폰 번호")
    @Column(name = "coupon_id", nullable = false, updatable = false)
    private Long couponId;

    @Comment(value = "멤버 아이디")
    @Column(name = "member_id", nullable = false, updatable = false)
    private String memberId;

    @Comment(value = "쿠폰 아웃박스 아이디")
    @Column(name = "coupon_outbox_id", unique = true, nullable = false, updatable = false)
    private Long couponOutboxId;

    @Comment(value = "생성일자")
    @Column(name = "create_datetime", nullable = false, updatable = false)
    private LocalDateTime createDatetime;

    @Builder
    public CouponHistoryEntity(Long id, Long couponId, String memberId, Long couponOutboxId, LocalDateTime createDatetime) {
        this.id = id;
        this.couponId = couponId;
        this.memberId = memberId;
        this.couponOutboxId = couponOutboxId;
        this.createDatetime = createDatetime;
    }
}
