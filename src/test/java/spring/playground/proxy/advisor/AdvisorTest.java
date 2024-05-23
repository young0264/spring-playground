package spring.playground.proxy.advisor;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import spring.playground.proxy.common.service.ServiceImpl;
import spring.playground.proxy.common.service.ServiceInterface;
import spring.playground.proxy.pureproxy.proxy.common.advice.TimeAdvice;

@Slf4j
public class AdvisorTest {

    @Test
    void advisorTest1() {
        ServiceInterface target = new ServiceImpl();
        ProxyFactory proxyFactory = new ProxyFactory(target);
        DefaultPointcutAdvisor advisor = new
                DefaultPointcutAdvisor(Pointcut.TRUE, new TimeAdvice());
        proxyFactory.addAdvisor(advisor); // 프록시 팩토리에 적용할 어드바이저(DefaultPointcutAdvisor)를 지정
        ServiceInterface proxy = (ServiceInterface) proxyFactory.getProxy();
        proxy.save();
        proxy.find();
    }

}
