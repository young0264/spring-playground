package spring.playground.basic;

import spring.playground.basic.member.Grade;
import spring.playground.basic.member.Member;
import spring.playground.basic.member.MemberService;
import spring.playground.basic.member.MemberServiceImpl;
import spring.playground.basic.order.Order;
import spring.playground.basic.order.OrderService;
import spring.playground.basic.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("oder = " + order);

    }
}
