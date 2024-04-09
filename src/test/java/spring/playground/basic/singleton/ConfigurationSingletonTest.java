package spring.playground.basic.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.playground.basic.AppConfig;
import spring.playground.basic.member.MemberRepository;
import spring.playground.basic.member.MemberServiceImpl;
import spring.playground.basic.order.OrderServiceImpl;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        // 모두 같은 인스턴스를 참조함을 알 수 있음.
        System.out.println("memberService -> memberRepository : " + memberService.getMemberRepository());
        System.out.println("orderService -> memberRepository : " + orderService.getMemberRepository());
        System.out.println("memberRepository : " + memberRepository);

        Assertions.assertThat(memberService.getMemberRepository()).isSameAs(memberRepository);
        Assertions.assertThat(orderService.getMemberRepository()).isSameAs(memberRepository);

    }

    @Test
    void configurationDeep() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //AppConfig도 스프링 빈으로 등록됨
        AppConfig bean = ac.getBean(AppConfig.class);

        //CGLIB 라이브러리를 사용해 생긴 다른 클래스를 스프링 빈으로 등록한 주소값이 나옴. ex) AppConfig@CGLIB
        System.out.println("bean : " + bean.getClass());
    }

}
