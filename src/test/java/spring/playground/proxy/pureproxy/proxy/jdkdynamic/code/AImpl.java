package spring.playground.proxy.pureproxy.proxy.jdkdynamic.code;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class AImpl implements AInterface{

    @Override
    public String call() {
        log.info("A 호출");
        return "a";
    }

}