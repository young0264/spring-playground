package spring.playground.proxy.advisor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import spring.playground.proxy.common.service.ServiceImpl;
import spring.playground.proxy.common.service.ServiceInterface;

@Slf4j
public class MultiAdvisorTest {
    @Test
    /**
     프록시 팩토리에 원하는 만큼 addAdvisor로 어드바이저를 등록,
     factory 1개 사용으로 성능이 더 좋음
     */
    @DisplayName("하나의 프록시, 여러 어드바이저")
    void multiAdvisorTest2() {
        //proxy -> advisor2 -> advisor1 -> target
        DefaultPointcutAdvisor advisor2
                = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2());
        DefaultPointcutAdvisor advisor1
                = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1());

        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory1 = new ProxyFactory(target);
        proxyFactory1.addAdvisor(advisor2);
        proxyFactory1.addAdvisor(advisor1);
        ServiceInterface proxy = (ServiceInterface) proxyFactory1.getProxy();
        //실행
        proxy.save();
    }

    @Test
    @DisplayName("여러 프록시") // 프록시를 여러개 생성한다는 문제.
    void multiAdvisorTest1() {

        //client -> proxy2(advisor2) -> proxy1(advisor1) -> target
        // (프록시 두번 생성의 단점)
        //proxyFactory1 [advisor1],
        //proxyFactory2 [advisor2],
        //
        //serviceImpl -> proxyFactory1 : proxy1
        //serviceImpl(proxy1) -> proxyFactory2

        //프록시1 생성
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory1 = new ProxyFactory(target); //ServiceInterface를 proxy로
        DefaultPointcutAdvisor advisor1
                = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice1()); //Advice1
        proxyFactory1.addAdvisor(advisor1);
        ServiceInterface proxy1 = (ServiceInterface) proxyFactory1.getProxy();

//        log.info("target toString : " + target.toString());
//        log.info("target getClass : " + target.getClass());
//        log.info("proxy1 toString : " + proxy1.toString());
//        log.info("proxy1 getClass : " + proxy1.getClass());
        //프록시2 생성, target -> proxy1 입력
        ProxyFactory proxyFactory2 = new ProxyFactory(proxy1);  //ServiceInterface proxy를 proxy로
        DefaultPointcutAdvisor advisor2
                = new DefaultPointcutAdvisor(Pointcut.TRUE, new Advice2()); //Advice2
        proxyFactory2.addAdvisor(advisor2);
        ServiceInterface proxy2 = (ServiceInterface) proxyFactory2.getProxy(); //실행
        log.info("=====================");

        proxy2.save();
    }

    @Slf4j
    static class Advice1 implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("advice1 호출. invoke");
            return invocation.proceed();
        }
    }

    @Slf4j
    static class Advice2 implements MethodInterceptor {
        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            log.info("advice2 호출. invoke");
            return invocation.proceed();
        }
    }

}
