package spring.playground.advanced.app.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import spring.playground.advanced.trace.TraceStatus;
import spring.playground.advanced.trace.log.LogTraceV2;

@Slf4j
//@RequestMapping
//@ResponseBody
@RestController
@RequiredArgsConstructor
public class OrderControllerV2 {
    private final OrderServiceV2 orderService;
//    public OrderControllerV2(OrderServiceV2 orderService) {
//        this.orderService = orderService;
//    }
    @GetMapping("/v2/request")
    public String request(@RequestParam("itemId") String itemId) {
        System.out.println("OrderControllerV2 start");
        orderService.orderItem(itemId);
        return "ok";
    }
    @GetMapping("/v2/no-log")
    public String noLog() {
        return "ok";
    }
}