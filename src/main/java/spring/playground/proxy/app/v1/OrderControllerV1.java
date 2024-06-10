package spring.playground.proxy.app.v1;

import org.springframework.web.bind.annotation.*;

@RestController
public interface OrderControllerV1 {
    public int t1 = 123;
    @GetMapping("/v1/request")
    String request(@RequestParam("itemId") String itemId);

    @GetMapping("/v1/no-log")
    String noLog();

}
