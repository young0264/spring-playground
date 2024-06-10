package spring.playground.proxy.pureproxy.proxy.jdkdynamic;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.playground.proxy.pureproxy.proxy.jdkdynamic.code.*;

import java.lang.reflect.Proxy;

@Slf4j
public class JdkDynamicProxyTest {

    /**
     * public interface InvocationHandler{
           public Object invoke(Object proxy, Method method, Object[] args){...}
     * }
     *
     * Processes a method invocation on a proxy instance and returns
     * the result.  This method will be invoked on an invocation handler
     * when a method is invoked on a proxy instance that it is
     * associated with.
     **/
    /**
     * 1. JDK 동적 프록시는 `InvocationHandler.invoke()` 를 호출
     *    (`TimeInvocationHandler` 가 구현체로 있으로 `TimeInvocationHandler.invoke()` 가 호출)
     * 2.
     **/
    @Test
    void dynamicA() {
        AInterface target = new AImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        log.info("========= invoke timing1 =========");

        // JAVA reflection API로 동적 proxy 객체 생성, call 메서드 실행
        AInterface proxy = (AInterface) Proxy.newProxyInstance(AInterface.class.getClassLoader()
                                    , new Class[] {AInterface.class}
                                    , handler);
        log.info("========= invoke timing2 =========");
        log.info("AInterface proxy : " + proxy.toString());
        proxy.call(); // AInterface로 타입캐스팅하여 call 메서드를 실행
        log.info("========= invoke timing3 =========");

        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
    }

    @Test
    void dynamicB() {
        BInterface target = new BImpl();
        TimeInvocationHandler handler = new TimeInvocationHandler(target);
        BInterface proxy = (BInterface)
                Proxy.newProxyInstance(BInterface.class.getClassLoader()
                                    , new Class[] {BInterface.class}
                                    , handler);
        proxy.call();
        log.info("targetClass = {}", target.getClass());
        log.info("proxyClass = {}", proxy.getClass());
    }

}
