package spring.playground.basic.logdemo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;
import spring.playground.basic.common.MyLogger;

@Service
@RequiredArgsConstructor
public class LogDemoService {

    private final MyLogger myLogger; //프록시 방식 사용시. 사용 가능
//    private final ObjectProvider<MyLogger> myProviderLogger;


    public void logic(String id) {
        myLogger.log("service id = " + id);
//        MyLogger myLogger = myProviderLogger.getObject();
        myLogger.log("service id : " + id);
    }

}
