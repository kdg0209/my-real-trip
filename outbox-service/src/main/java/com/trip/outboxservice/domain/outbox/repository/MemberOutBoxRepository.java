package com.trip.outboxservice.domain.outbox.repository;

import com.trip.outboxservice.domain.outbox.domain.MemberOutBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberOutBoxRepository extends JpaRepository<MemberOutBox, Long> {
}
