package spring.playground.basic.web;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import spring.playground.basic.common.MyLogger;
import spring.playground.basic.logdemo.LogDemoService;

@Controller
@RequiredArgsConstructor
public class LogDemoController {

//    private final LogDemoService logDemoService;
//    private final ObjectProvider<MyLogger> myProviderLogger;
    private final MyLogger myLogger; //프록시 방식 사용시. 사용 가능

    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString();

//        MyLogger myLoggerObj = myProviderLogger.getObject();
//        myLoggerObj.setRequestURL(requestURL);
//        myLoggerObj.log("controller test");
//

        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
//        logDemoService.logic("testId");

        System.out.println("myProxyLogger : " + myLogger);
        System.out.println("myProxyLogger getClass : " + myLogger.getClass());

        return "OK";
    }
}
