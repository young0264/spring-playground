package spring.playground.basic.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.playground.basic.member.Grade;
import spring.playground.basic.member.Member;

@Component // 선언시 RateDiscountPolicy에서 'DiscountPolicy'이 bean으로 등록되어 NoUniqueBeanDefinitionException 에러 발생
public class FixDiscountPolicy implements DiscountPolicy {

    private int discountFixAmount = 1000; //만큼의 금액 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
