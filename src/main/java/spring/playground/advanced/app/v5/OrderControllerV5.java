package spring.playground.advanced.app.v5;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.playground.advanced.trace.logtrace.LogTrace;
import spring.playground.advanced.trace.template.AbstractTemplate;

@Slf4j
@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {
    private final OrderServiceV5 orderService;
    private final LogTrace trace;

    @GetMapping("/v5/request")
    public String request(@RequestParam(value="itemId") String itemId) {

        AbstractTemplate<String> template = new AbstractTemplate<>(trace) {
            @Override
            protected String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        };

        return template.execute("OrderController V5. request()");


//        log.info("/v5/request, itemId : " + itemId);
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