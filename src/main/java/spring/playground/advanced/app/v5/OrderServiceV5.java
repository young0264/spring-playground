package spring.playground.advanced.app.v5;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.playground.advanced.trace.logtrace.LogTrace;
import spring.playground.advanced.trace.template.AbstractTemplate;

@Service
@RequiredArgsConstructor
public class OrderServiceV5 {
    private final OrderRepositoryV5 orderRepository;
    private final LogTrace trace;
    public void orderItem(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                orderRepository.save(itemId);
                return null;
            }
        };

        template.execute("OrderService.orderItem() V5");
//        TraceStatus status = null;
//        try {
//            status = trace.begin("OrderService.orderItem()");
//            orderRepository.save(itemId);
//            trace.end(status);
//        } catch (Exception e) {
//            trace.exception(status, e);
//            throw e;
//        }
    }
}