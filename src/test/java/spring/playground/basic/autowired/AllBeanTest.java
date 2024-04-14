package spring.playground.basic.autowired;

import lombok.Getter;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.playground.basic.AutoAppConfig;
import spring.playground.basic.discount.DiscountPolicy;
import spring.playground.basic.member.Grade;
import spring.playground.basic.member.Member;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class AllBeanTest {


    @Test
    void findAllBean() {
        ApplicationContext ac = new
                AnnotationConfigApplicationContext(
                        AutoAppConfig.class,
                        DiscountService.class); // 스프링컨테이너에 스프링 bean으로 AutoAppConfig, DiscountService를 자동 등록
        DiscountService discountService = ac.getBean(DiscountService.class);
        System.out.println("getPolicies : " + discountService.getPolicies());
        System.out.println("getPolicyMap : " + discountService.getPolicyMap().get("fixDiscountPolicy"));
        Member member = new Member(1L, "userA", Grade.VIP);
        int discountPrice = discountService.discount(
                                                      member,
                                                10000,
                                          "fixDiscountPolicy");
        assertThat(discountService).isInstanceOf(DiscountService.class);
        assertThat(discountPrice).isEqualTo(1000);
    }

    @Getter
    static class DiscountService {
        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> policies;

        /**
         * [자동등록] 이쪽이 좀 신기한데
         *      이 코드를 보고 DiscountPolicy로 등록된 bean들을 Map과 List로 받는다는것을 알 수 있어야함
         *        -> 가독성이 좋다 생각될?
         * [수동등록] : DiscountPolicyConfig.class
         * */
        public DiscountService(Map<String, DiscountPolicy> policyMap, // DiscountPolicy 타입으로 조회한 모든 스프링 빈을 담아준다.
                               List<DiscountPolicy> policies) {       // DiscountPolicy 타입으로 조회한 모든 스프링 빈을 담아준다.
                                                                      // 만약 해당 타입의 bean이 없으면 빈 컬렉션이나 Map을 주입하게됨
            this.policyMap = policyMap;
            this.policies = policies;
            System.out.println("policyMap = " + policyMap);
            System.out.println("policies = " + policies);
        }

        public int discount(Member member, int price, String discountCode) { // 'fixDiscountPolicy'가 넘어옴
            DiscountPolicy discountPolicy = policyMap.get(discountCode);
            System.out.println("discountCode = " + discountCode);
            System.out.println("discountPolicy = " + discountPolicy);
            return discountPolicy.discount(member, price);
        }
    }

}
