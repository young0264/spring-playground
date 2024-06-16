package spring.playground.proxy.proxyfactory;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.AopUtils;
import spring.playground.proxy.common.advice.TimeAdvice;
import spring.playground.proxy.common.service.ConcreteService;
import spring.playground.proxy.common.service.ServiceImpl;
import spring.playground.proxy.common.service.ServiceInterface;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class ProxyFactoryTest {

    @Test
    @DisplayName("인터페이스가 있으면 JDK 동적 프록시 사용")
    void interfaceProxy() {
        ServiceInterface target = new ServiceImpl(); //인터페이스 ServiceInterface에 proxy 적용
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());

        proxy.save(); // 동작 시점.

        //프록시 팩토리를 통해서 프록시가 생성되면 JDK 동적 프록시나, CGLIB 모두 true
        assertThat(AopUtils.isAopProxy(proxy)).isTrue();

        //프록시 팩토리를 통해서 프록시가 생성 -> jdk 동적 프록시 true
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isTrue();

        //프록시 팩토리를 통해서 프록시가 생성. -> CGLIB 동적 프록시 false
        assertThat(AopUtils.isCglibProxy(proxy)).isFalse();
    }


    @Test
    @DisplayName("구체 클래스만 있으면 CGLIB 사용") void concreteProxy() {
        ConcreteService target = new ConcreteService(); //구체클래스 ConcreteService에 proxy 적용
        ProxyFactory proxyFactory = new ProxyFactory(target);
        proxyFactory.addAdvice(new TimeAdvice());

        ConcreteService proxy = (ConcreteService) proxyFactory.getProxy();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());

        proxy.call();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse(); //jdk 동적 프록시 false
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }

    @Test
    @DisplayName("ProxyTargetClass 옵션을 사용하면 인터페이스가 있어도 CGLIB를 사용하고, 클래스 기반 프록시 사용")
    void proxyTargetClass() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);

        // 추가.. 인터페이스가 있어도 강제로 CGLIB을 사용. 인터페이스가 아닌 클래스 기반의 프록시를 생성해줌
        proxyFactory.setProxyTargetClass(true);
        proxyFactory.addAdvice(new TimeAdvice());

        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());

        proxy.save();

        assertThat(AopUtils.isAopProxy(proxy)).isTrue();
        assertThat(AopUtils.isJdkDynamicProxy(proxy)).isFalse();
        assertThat(AopUtils.isCglibProxy(proxy)).isTrue();
    }

    /** 스프링부트는 AOP 적용시 기본적으로 ProxyTargetClass가 true임 */

}
