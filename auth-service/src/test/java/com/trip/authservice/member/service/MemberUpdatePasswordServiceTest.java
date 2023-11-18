package com.trip.authservice.member.service;

import com.trip.authservice.config.IntegrationTest;
import com.trip.authservice.member.application.port.in.MemberUpdatePasswordUsecase;
import com.trip.authservice.member.dto.request.MemberUpdatePasswordRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

class MemberUpdatePasswordServiceTest extends IntegrationTest {

    @Autowired
    private MemberUpdatePasswordUsecase memberUpdatePasswordUsecase;

    @Test
    @Sql(scripts = "/sql/member/member-default-insert.sql")
    void 정상적인_값을_사용하여_멤버의_비밀번호를_변경할_수_있다() {

        // given
        var id = "test";
        var password = "1234567890";
        var request = new MemberUpdatePasswordRequest(id, password);

        // when
        var result = memberUpdatePasswordUsecase.updatePassword(request);

        // then
        assertThat(result).isNotNull();
        assertThat(result.id()).isEqualTo("test");
    }
}