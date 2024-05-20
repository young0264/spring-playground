package spring.playground.proxy.pureproxy.proxy;

import org.junit.jupiter.api.Test;
import spring.playground.proxy.pureproxy.proxy.code.CacheProxy;
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

    /**
     * 프록시를 통해 접근하여 접근제어.
     **/
    @Test
    void cacheProxyTest() {
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject); //realSubject를 참조함.
        ProxyPatternClient client = new ProxyPatternClient(cacheProxy);
        client.execute();
        client.execute();
        client.execute();
    }

}
