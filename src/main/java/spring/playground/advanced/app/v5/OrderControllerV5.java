package spring.playground.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.playground.advanced.trace.callback.TraceCallback;
import spring.playground.advanced.trace.callback.TraceTemplate;
import spring.playground.advanced.trace.logtrace.LogTrace;
import spring.playground.advanced.trace.template.AbstractTemplate;

@Slf4j
@RestController
//@RequiredArgsConstructor
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final TraceTemplate template;

    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
        this.orderService = orderService;
        this.template = new TraceTemplate(trace);
    }

    @GetMapping("/v5/request")
    public String request(@RequestParam(value="itemId") String itemId) {

        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
    }

}