package spring.playground.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import spring.playground.advanced.trace.strategy.code.Strategy;

/**
 * 여러 전략을 파라미터로 전달해서 더욱 유연하게 변경할 수 있음.
 * Strategy를 전달하는 방식
 * */
@Slf4j
public class ContextV2 {

    public void execute(Strategy strategy) {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행
        strategy.call(); //위임
        //비즈니스 로직 종료

        long endTime = System.currentTimeMillis(); long resultTime = endTime - startTime;

        log.info("resultTime={}", resultTime);
    }
}
