package com.trip.authservice.member.domain;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberPasswordTest {

    @Test
    void 정상적인_값을_사용하여_비밀번호를_생성할_수_있다() {

        // given
        String password = "12345";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // when
        MemberPassword result = new MemberPassword(password, encoder);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 공백인_문자열을_사용하여_비밀번호를_생성하면_예외가_발생한다() {

        // given
        String password = "    ";
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // when && then
        assertThatThrownBy(() -> new MemberPassword(password, encoder))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void NULL인_값을_사용하여_비밀번호를_생성하면_예외가_발생한다() {

        // given
        String password = null;
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        // when && then
        assertThatThrownBy(() -> new MemberPassword(password, encoder))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 정상적인지_않은_인코딩을_사용하여_비밀번호를_생성하면_예외가_발생한다() {

        // given
        String password = "12345";
        PasswordEncoder encoder = null;

        // when && then
        assertThatThrownBy(() -> new MemberPassword(password, encoder))
                .isInstanceOf(IllegalStateException.class);

    }
}