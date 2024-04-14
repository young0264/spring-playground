package spring.playground.basic.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.playground.basic.annotation.MainDiscountPolicy;
import spring.playground.basic.member.Grade;
import spring.playground.basic.member.Member;

//정률 할인정책
@Component
//@Primary //제외시 FixDiscountPolicy와 NoUniqueBeanDefinitionException 터짐
@MainDiscountPolicy // @Primary 또는 @Qualifier("mainDiscountPolicy") 대신 어노테이션 생성
public class RateDiscountPolicy implements DiscountPolicy {

    private int discountPercent = 10; //10% 할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price*discountPercent/100;
        } else {
            return 0;
        }
    }
}
