package spring.playground.basic.discount;

import spring.playground.basic.member.Grade;
import spring.playground.basic.member.Member;

//정률 할인정책
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; //10% 할인

//    public RateDiscountPolicy(RateDiscountPolicy rateDiscountPolicy) {
//        this.discountPercent = rateDiscountPolicy;
//    }

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price*discountPercent/100;
        } else {
            return 0;
        }
    }
}
