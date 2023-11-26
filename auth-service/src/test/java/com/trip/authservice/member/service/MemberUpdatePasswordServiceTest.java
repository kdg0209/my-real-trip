package com.trip.authservice.member.service;

import com.trip.authservice.config.IntegrationTest;
import com.trip.authservice.global.exception.types.InValidException;
import com.trip.authservice.member.application.port.in.MemberUpdatePasswordUsecase;
import com.trip.authservice.member.dto.request.MemberUpdatePasswordRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Sql(scripts = "/sql/member/member-default-insert.sql")
    @NullSource
    @ValueSource(strings = {"", "    "})
    @ParameterizedTest
    void 잘못된_입력값을_사용하여_비밀번호를_변경하는_경우_예외가_발생한다(String password) {

        // given
        var id = "test";
        var request = new MemberUpdatePasswordRequest(id, password);

        // when && then
        assertThatThrownBy(() -> memberUpdatePasswordUsecase.updatePassword(request))
                .isInstanceOf(InValidException.class);
    }
}