package com.trip.authservice.member.application.port.out;

import com.trip.authservice.member.domain.Member;

public interface FindMemberPort {

    Member findById(String id);
}
