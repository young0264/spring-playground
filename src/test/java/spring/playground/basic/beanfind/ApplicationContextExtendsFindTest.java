package spring.playground.basic.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.playground.basic.discount.DiscountPolicy;
import spring.playground.basic.discount.FixDiscountPolicy;
import spring.playground.basic.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(TestConfig.class);

    @Configuration
    static class TestConfig {
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }
        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

    @Test
    void 부모타입으로_조회시_자식이_둘이상이면_중복오류발생() {
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));
    }

    @Test
    void 부모타입으로_조회시_자식이_둘이상이면_빈이름지정하면됨() { //하위 타입으로도 검증 가능
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy)
                .isInstanceOf(DiscountPolicy.class);
        assertThat(rateDiscountPolicy)
                .isInstanceOf(RateDiscountPolicy.class);
    }

    @Test //상위타입에 2개의 타입이 겹치는게 문제였고, 이 하위타입은 한개라 괜찮음
    void 특정_하위타입으로_조회() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    // getBeansOfType 의 key는 자식타입으로 되는구나
    //Return the bean instances that match the given object type (including subclasses),
    @Test
    void 부모타입으로_모두_조회() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);

        //Returns a Set view of the keys contained in this map.
        for (String key : beansOfType.keySet()) {
            System.out.println("key : "+ key + " value : "+ beansOfType.get(key));
        }
    }

    @Test
    void 최상위_부모타입인_Object_모두_조회() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key : "+ key + " value : "+ beansOfType.get(key));
        }
    }


}
