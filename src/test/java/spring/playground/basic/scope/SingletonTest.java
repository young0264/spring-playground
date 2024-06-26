package spring.playground.basic.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {


    @Test
    public void singletonBeanFind() {
        System.out.println("before make singletone bean container");
        AnnotationConfigApplicationContext ac = new
                AnnotationConfigApplicationContext(SingletonBean.class);
        System.out.println("after make singletone bean container");

        SingletonBean singletonBean1 = ac.getBean(SingletonBean.class);
        SingletonBean singletonBean2 = ac.getBean(SingletonBean.class);
        System.out.println("singletonBean1 = " + singletonBean1);
        System.out.println("singletonBean2 = " + singletonBean2);
        assertThat(singletonBean1).isSameAs(singletonBean2);
        ac.close(); //종료 }
    }

    @Scope("singleton")
    static class SingletonBean {
        @PostConstruct
        public void init() { // 싱글톤 socpe에서는 '스프링 컨테이너 생성 시점에' 초기화 메서드가 실행됨.
            System.out.println("SingletonBean.init");
        }
        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        } }
}
