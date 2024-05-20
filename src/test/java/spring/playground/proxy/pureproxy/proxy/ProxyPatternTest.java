package spring.playground.proxy.pureproxy.proxy;

import org.junit.jupiter.api.Test;
import spring.playground.proxy.pureproxy.proxy.code.ProxyPatternClient;
import spring.playground.proxy.pureproxy.proxy.code.RealSubject;

public class ProxyPatternTest {

    @Test
    void noProxyTest() {
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient client = new ProxyPatternClient(realSubject);
        client.execute();
        client.execute();
        client.execute();
    }

}
