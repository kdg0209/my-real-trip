package com.trip.authservice.member.repository;

import com.trip.authservice.member.adapter.out.persistence.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
}
