package spring.playground.proxy.config.v1_proxy.concrete_proxy;

import spring.playground.advanced.app.v2.OrderRepositoryV2;
import spring.playground.advanced.trace.TraceId;
import spring.playground.advanced.trace.log.LogTraceV2;
import spring.playground.proxy.trace.TraceStatus;
import spring.playground.proxy.trace.logtrace.LogTrace;

public class OrderRepositoryConcreteProxy extends OrderRepositoryV2 {

    private final OrderRepositoryV2 target;
    private final LogTrace logTrace;

    public OrderRepositoryConcreteProxy(OrderRepositoryV2 target, LogTrace logTrace) {
        this.target = target;
        this.logTrace = logTrace;
    }

    @Override
    public void save(String itemId) {
        TraceStatus status = null;
        try {
            status = logTrace.begin("OrderRepository.save()"); //target 호출
            target.save(itemId);
            logTrace.end(status);
        } catch (Exception e) {
            logTrace.exception(status, e);
            throw e;
        }
    }


}
