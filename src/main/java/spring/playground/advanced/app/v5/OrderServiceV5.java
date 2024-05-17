package spring.playground.advanced.app.v5;


import org.springframework.stereotype.Service;
import spring.playground.advanced.trace.callback.TraceTemplate;
import spring.playground.advanced.trace.logtrace.LogTrace;

@Service
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace logTrace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(logTrace);
    }

    public void orderItem(String itemId) {
        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }

}