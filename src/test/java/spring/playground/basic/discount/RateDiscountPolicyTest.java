package spring.playground.basic.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import spring.playground.basic.member.Grade;
import spring.playground.basic.member.Member;

class RateDiscountPolicyTest {

    private final String VIP_MEMBER = "memberVIP";
    private final String BASIC_MEMBER = "memberBasic";
    private final int TEN_THOUSAND = 10000;
    private final int THOUSAND = 1000;
    private final int ZERO = 0;

    RateDiscountPolicy discountPolicy;

    @Test
    void VIP는_10퍼_할인이_적용() {
        discountPolicy = new RateDiscountPolicy(new RateDiscountPolicy());
        //given
        Member member = new Member(1L, VIP_MEMBER, Grade.VIP);
        //when
        int discount = discountPolicy.discount(member, TEN_THOUSAND);
        //then
        Assertions.assertThat(discount).isEqualTo(THOUSAND);
    }

    @Test
    void VIP등급만_할인이_적용되는지() {
        //given
        Member member = new Member(2L, BASIC_MEMBER, Grade.BASIC);
        //when
        int discount = discountPolicy.discount(member, TEN_THOUSAND);
        //then
        Assertions.assertThat(discount).isEqualTo(ZERO);
    }
}