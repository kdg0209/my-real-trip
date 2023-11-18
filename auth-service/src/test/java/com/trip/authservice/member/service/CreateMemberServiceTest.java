package com.trip.authservice.member.service;

import com.trip.authservice.config.IntegrationTest;
import com.trip.authservice.member.application.port.in.CreateMemberUsecase;
import com.trip.authservice.member.dto.request.MemberCreateRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CreateMemberServiceTest extends IntegrationTest {

    @Autowired
    private CreateMemberUsecase createMemberUsecase;

    @Test
    void 정상적인_값을_사용하여_멤버를_생성할_수_있다() {

        // given
        var request = new MemberCreateRequest("test", "123456", "홍길동", "KDG", "test@naver.com");

        // when
        var result = createMemberUsecase.create(request);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    @Sql(scripts = "/sql/member/member-duplicate-id-insert.sql")
    void 멤버_생성시_아이디가_중복이_되는_경우_예외가_발생한다() {

        // given
        var request = new MemberCreateRequest("test", "123456", "홍길동", "KDG", "test@naver.com");

        // when && then
        assertThatThrownBy(() -> createMemberUsecase.create(request))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @Sql(scripts = "/sql/member/member-duplicate-email-insert.sql")
    void 멤버_생성시_이메일이_중복이_되는_경우_예외가_발생한다() {

        // given
        var request = new MemberCreateRequest("test 1234", "123456", "홍길동", "KDG", "test@naver.com");

        // when && then
        assertThatThrownBy(() -> createMemberUsecase.create(request))
                .isInstanceOf(IllegalArgumentException.class);

    }
}