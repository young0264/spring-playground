package spring.playground.basic;

import spring.playground.basic.discount.DiscountPolicy;
import spring.playground.basic.discount.FixDiscountPolicy;
import spring.playground.basic.discount.RateDiscountPolicy;
import spring.playground.basic.member.MemberRepository;
import spring.playground.basic.member.MemberService;
import spring.playground.basic.member.MemberServiceImpl;
import spring.playground.basic.member.MemoryMemberRepository;
import spring.playground.basic.order.OrderService;
import spring.playground.basic.order.OrderServiceImpl;

/** 객체를 구성(configuration) 하는 영역 */
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

}
