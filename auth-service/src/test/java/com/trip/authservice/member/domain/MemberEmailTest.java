package com.trip.authservice.member.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberEmailTest {

    @Test
    void 정상적인_값을_사용하여_이메일을_생성할_수_있다() {

        // given
        String email = "test@naver.com";

        // when
        MemberEmail result = new MemberEmail(email);

        // then
        assertThat(result).isNotNull();
    }

    @ParameterizedTest
    @ValueSource(strings = {"test@.com", "test@naver.", "testnaver.com", "test@navercom"})
    void 비정상적인_문자열을_사용하여_이메일을_생성하면_예외가_발생한다(String email) {

        // when && then
        assertThatThrownBy(() -> new MemberEmail(email))
                .isInstanceOf(IllegalArgumentException.class);
    }
}