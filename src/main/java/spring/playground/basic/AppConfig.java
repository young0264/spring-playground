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
@Configuration
public class AppConfig {

    // memberService, orderService 모두 memberRepository를 바라봄
    // -> 따라서 구현체쪽에 getter 메서드 추가.
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean // 스프링 컨테이너가 spring bean에 등록하기위해 @Bean이 붙어있는 memberRepository 호출
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
