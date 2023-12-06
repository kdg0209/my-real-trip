package com.trip.authservice.outbox.application.port.out;

import com.trip.authservice.outbox.domain.MemberOutBox;

public interface CreateMemberOutBoxPort {

    void createMemberOutBox(MemberOutBox memberOutBox);
}
