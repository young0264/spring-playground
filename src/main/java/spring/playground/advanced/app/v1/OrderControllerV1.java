package spring.playground.advanced.app.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.playground.advanced.trace.TraceStatus;
import spring.playground.advanced.trace.log.LogTraceV1;

@RestController
@RequiredArgsConstructor
public class OrderControllerV1 {
    private final OrderServiceV1 orderService;
    private final LogTraceV1 trace;

    @GetMapping("/v1/request")
    public String request(@RequestParam(value="itemId") String itemId) {

        System.out.println("/v1/request, itemId : " + itemId);
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 함.
        }
    }
}