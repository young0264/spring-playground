package spring.playground.basic.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.playground.basic.AppConfig;
import spring.playground.basic.member.MemberRepository;
import spring.playground.basic.member.MemoryMemberRepository;

import java.util.Map;

class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new
            AnnotationConfigApplicationContext(SameBeanConfig.class);

    // 테스트용 bean이름(메서드명) 추가
    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }
        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }

    @Test
    void 타입으로_조회시_같은_타입이_두개이상이면_중복오류발생() {
//        MemberRepository bean = ac.getBean(MemberRepository.class);
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->
                ac.getBean(MemberRepository.class));
//        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () ->
//                ac.getBean(MemberRepository.class));
    }

    @Test
    void 타입으로_조회시_같은_타입이_두개이상이면_빈이름지정하면됨() {
        MemberRepository memberRepository = ac.getBean("memberRepository1",
                MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(memberRepository).isInstanceOf(MemberRepository.class);
    }

    @Test
    void 특정_타입을_모두_조회하기() {
        Map<String, MemberRepository> beansOfType =
                ac.getBeansOfType(MemberRepository.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " value = " +
                    beansOfType.get(key));
        }
        System.out.println("beansOfType = " + beansOfType);
        org.assertj.core.api.Assertions.assertThat(beansOfType.size()).isEqualTo(2);
    }


}
