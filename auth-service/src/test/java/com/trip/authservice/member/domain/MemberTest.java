package com.trip.authservice.member.domain;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

class MemberTest {

    @Test
    void 정상적인_값을_사용하여_멤버를_생성할_수_있다() {

        // given
        String id = "TEST";
        MemberPassword password = new MemberPassword("123456", new BCryptPasswordEncoder());
        String name = "홍길동";
        String nickName = "KDG";
        MemberEmail email = new MemberEmail("test@naver.com");

        // when
        Member result = Member.create(id, password, name, nickName, email);

        // then
        assertThat(result).isNotNull();
    }
}