package spring.playground.basic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.playground.basic.discount.DiscountPolicy;
import spring.playground.basic.discount.RateDiscountPolicy;
import spring.playground.basic.member.MemberRepository;
import spring.playground.basic.member.MemberService;
import spring.playground.basic.member.MemberServiceImpl;
import spring.playground.basic.member.MemoryMemberRepository;
import spring.playground.basic.order.OrderService;
import spring.playground.basic.order.OrderServiceImpl;

/** 객체를 구성(configuration) 하는 영역 */
//@Configuration // CGLIB 기술을 사용, 주석시에 스프링 컨테이너에 싱글톤으로 보장 X
public class AppConfig {

    // memberService, orderService 모두 memberRepository를 바라봄
    // -> 따라서 구현체쪽에 getter 메서드 추가.
    //@Bean만 사용해도 스프링 빈으로 등록되지만, 싱글톤은 보장하지 않음
    @Bean // MemberServiceImpl -> memberRepository
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean // OrderServiceImpl -> memberRepository
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    // 스프링 컨테이너가 spring bean에 등록하기위해 @Bean이 붙어있는 memberRepository 호출
    @Bean // memberRepository
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }

}
