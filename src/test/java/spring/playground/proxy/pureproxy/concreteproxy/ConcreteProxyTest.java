package spring.playground.proxy.pureproxy.concreteproxy;

import org.junit.jupiter.api.Test;
import spring.playground.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import spring.playground.proxy.pureproxy.concreteproxy.code.ConcreteLogic;
import spring.playground.proxy.pureproxy.concreteproxy.code.TimeProxy;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

    // client : time 실행 -> concreteLogic 실행 -> 이후 time result-time 출력
    @Test
    void addProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        TimeProxy timeProxy = new TimeProxy(concreteLogic);
        ConcreteClient client = new ConcreteClient(timeProxy);
        client.execute();
    }

}
