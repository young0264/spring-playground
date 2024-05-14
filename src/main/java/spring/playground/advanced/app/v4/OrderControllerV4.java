package spring.playground.advanced.app.v4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.playground.advanced.trace.TraceStatus;
import spring.playground.advanced.trace.logtrace.LogTrace;
import spring.playground.advanced.trace.template.AbstractTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderControllerV4 {
    private final OrderServiceV4 orderService;
    private final LogTrace trace;

    @GetMapping("/v4/request")
    public String request(@RequestParam(value="itemId") String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };
        return template.execute("OrderController V4. request()");


//        log.info("/v4/request, itemId : " + itemId);
//        TraceStatus status = null;
//        try {
//            status = trace.begin("OrderController4.request()");
//            orderService.orderItem(itemId);
//            trace.end(status);
//            return "ok";
//        } catch (Exception e) {
//            trace.exception(status, e);
//            throw e; // 예외를 꼭 다시 던져주어야 함.
//        }
    }

}