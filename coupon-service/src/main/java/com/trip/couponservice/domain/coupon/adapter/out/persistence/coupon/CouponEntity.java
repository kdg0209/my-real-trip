package com.trip.couponservice.domain.coupon.adapter.out.persistence.coupon;

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
@Table(name = "coupon")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CouponEntity {

    @Id
    @Tsid
    private Long id;

    @Comment(value = "쿠폰명")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Comment(value = "쿠폰 상태")
    @Column(name = "status", nullable = false)
    private String status;

    @Comment(value = "생성일자")
    @Column(name = "create_datetime", nullable = false, updatable = false)
    private LocalDateTime createDatetime;

    @Builder
    public CouponEntity(Long id, String name, String status, LocalDateTime createDatetime) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.createDatetime = createDatetime;
    }
}
