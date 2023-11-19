package com.trip.authservice.member.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MemberTest {

    @Test
    void 정상적인_값을_사용하여_멤버를_생성할_수_있다() {

        // given
        var id = "TEST";
        var password = "123456";
        var name = "홍길동";
        var nickName = "KDG";
        var email = new MemberEmail("test@naver.com");

        // when
        var result = Member.create(id, password, name, nickName, email);

        // then
        assertThat(result).isNotNull();
    }

    @Test
    void 정상적인_값을_사용하여_멤버의_비밀번호를_변경할_수_있다() {

        // given
        var password = "1234567890";
        var member = findMember();

        // when
        member.updatePassword(password);

        // then
        assertThat(member.getPassword()).isEqualTo("1234567890");
    }

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "     ",})
    void 잘못된_값을_사용하여_비밀번호를_변경하는_경우_예외가_발생한다(String password) {
        var member = findMember();
        assertThatThrownBy(() -> member.updatePassword(password))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Member findMember() {
        String id = "TEST";
        String password = "123456";
        String name = "홍길동";
        String nickName = "KDG";
        MemberEmail email = new MemberEmail("test@naver.com");

        return Member.create(id, password, name, nickName, email);
    }
}