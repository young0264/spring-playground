package spring.playground.advanced.app.v5;

import org.springframework.stereotype.Repository;
import spring.playground.advanced.trace.callback.TraceTemplate;
import spring.playground.advanced.trace.logtrace.LogTrace;

@Repository
public class OrderRepositoryV5 {

    private final TraceTemplate template;

    public OrderRepositoryV5(LogTrace logTrace) {
        this.template = new TraceTemplate(logTrace);
    }

    public void save(String itemId) {

        template.execute("OrderRepository.save()", () -> {
            //저장로직
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외 발생!");
            }
            sleep(1000);
            return null;
        });

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
