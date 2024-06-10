package spring.playground.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.playground.jdkdynamic.code.*;

import java.lang.reflect.Proxy; // 동적 프록시

@Slf4j
public class JdkDynamicProxyTest {

    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target); // 동적 프록시에 적용할 핸들러 로직

        /**
         * 클래스 로더 정보, 인터페이스, 핸들러 로직 삽입, 생성,
         * -> 동적 프록시를 생성 및 결과 반환
         * 프록시 인스턴스의 메서드가 호출될 때마다 handler의 invoke가 호출됨
         **/
        AInterface proxy = (AInterface)
                Proxy.newProxyInstance(
                        AInterface.class.getClassLoader() // 클래스 로더 정보
                        , new Class[]{AInterface.class}
                        , handler);
        log.info("=====");
        proxy.call();
        log.info("=====");
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        BInterface proxy = (BInterface)
                Proxy.newProxyInstance(
                        BInterface.class.getClassLoader()
                        , new Class[]{BInterface.class}
                        , handler);
        proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
    }

}
