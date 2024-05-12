package spring.playground.advanced.app.v3.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.playground.advanced.trace.TraceStatus;
import spring.playground.advanced.trace.log.LogTraceV2;
import spring.playground.advanced.trace.logtrace.LogTrace;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderControllerV3 {
    private final OrderServiceV3 orderService;
    private final LogTrace trace;

    @GetMapping("/v3/request")
    public String request(@RequestParam(value="itemId") String itemId) {

        log.info("/v3/request, itemId : " + itemId);
        TraceStatus status = null;
        try {
            status = trace.begin("OrderController3.request()");
            orderService.orderItem(itemId);
            trace.end(status);
            return "ok";
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; // 예외를 꼭 다시 던져주어야 함.
        }
    }

}