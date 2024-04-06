package spring.playground.basic.order;

import spring.playground.basic.discount.DiscountPolicy;
import spring.playground.basic.discount.FixDiscountPolicy;
import spring.playground.basic.member.Member;
import spring.playground.basic.member.MemberRepository;
import spring.playground.basic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
