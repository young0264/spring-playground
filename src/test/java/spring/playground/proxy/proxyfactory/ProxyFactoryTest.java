package spring.playground.proxy.proxyfactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import spring.playground.proxy.common.advice.TimeAdvice;
import spring.playground.proxy.common.service.ServiceImpl;
import spring.playground.proxy.common.service.ServiceInterface;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용") void interfaceProxy() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        log.info("targetClass={}", target.getClass());
        log.info("proxyClass={}", proxy.getClass());

        proxy.save(); // 동작 시점.

        //프록시 팩토리를 통해서 프록시가 생성되면 JDK 동적 프록시나, CGLIB 모두 참
        assertThat(AopUtils.isAopProxy(proxy)).isTrue();

        //프록시 팩토리를 통해서 프록시가 생성 -> jdk 동적 프록시 참
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();

        //프록시 팩토리를 통해서 프록시가 생성. -> CGLIB 동적 프록시 참
        assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }

}
