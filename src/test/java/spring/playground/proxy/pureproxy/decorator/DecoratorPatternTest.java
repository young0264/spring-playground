package spring.playground.proxy.pureproxy.decorator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.playground.proxy.pureproxy.decorator.code.Component;
import spring.playground.proxy.pureproxy.decorator.code.DecoratorPatternClient;
import spring.playground.proxy.pureproxy.decorator.code.MessageDecorator;
import spring.playground.proxy.pureproxy.decorator.code.RealComponent;

@Slf4j
public class DecoratorPatternTest {

    @Test
    void noDecorator() {
        Component realComponent = new RealComponent();
        DecoratorPatternClient client = new
                DecoratorPatternClient(realComponent);
        client.execute();
    }

    /** client -> messageDecorator -> realComponent` */
    @Test
    void decorator1() {
        Component realComponent = new RealComponent();
        MessageDecorator messageDecorator = new MessageDecorator(realComponent);
        DecoratorPatternClient client = new
                DecoratorPatternClient(messageDecorator);
        client.execute();
    }

}
