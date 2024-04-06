package spring.playground.basic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.playground.basic.member.Grade;
import spring.playground.basic.member.Member;
import spring.playground.basic.member.MemberService;
import spring.playground.basic.member.MemberServiceImpl;
import spring.playground.basic.order.Order;
import spring.playground.basic.order.OrderService;
import spring.playground.basic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class); // 일단 매번 초기화

        MemberService memberService = applicationContext
                .getBean("memberService", MemberService.class); //메서드명으로 검색
        OrderService orderService = applicationContext
                .getBean("orderService", OrderService.class);


        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("oder = " + order);

    }
}
