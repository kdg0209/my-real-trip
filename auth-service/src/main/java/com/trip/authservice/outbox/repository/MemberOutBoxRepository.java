package com.trip.authservice.outbox.repository;

import com.trip.authservice.outbox.adapter.out.persistence.MemberOutBoxEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberOutBoxRepository extends JpaRepository<MemberOutBoxEntity, Long> {
}
