package spring.playground.advanced.app.v3.v2;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.playground.advanced.trace.TraceId;
import spring.playground.advanced.trace.TraceStatus;
import spring.playground.advanced.trace.log.LogTraceV2;
import spring.playground.advanced.trace.logtrace.LogTrace;

@Service
@RequiredArgsConstructor
public class OrderServiceV3 {
    private final OrderRepositoryV3 orderRepository;
    private final LogTrace trace;
    public void orderItem(String itemId) {
        TraceStatus status = null;
        try {
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }
}