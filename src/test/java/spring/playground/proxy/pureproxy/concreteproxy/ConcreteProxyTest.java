package spring.playground.proxy.pureproxy.concreteproxy;

import org.junit.jupiter.api.Test;
import spring.playground.proxy.pureproxy.concreteproxy.code.ConcreteClient;
import spring.playground.proxy.pureproxy.concreteproxy.code.ConcreteLogic;

public class ConcreteProxyTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient client = new ConcreteClient(concreteLogic);
        client.execute();
    }

}
