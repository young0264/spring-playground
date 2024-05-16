package spring.playground.advanced.trace.strategy;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.playground.advanced.trace.strategy.code.Strategy;
import spring.playground.advanced.trace.strategy.code.StrategyLogic1;
import spring.playground.advanced.trace.strategy.code.StrategyLogic2;

@Slf4j
public class ContextV2Test {

    /**
     * 전략 패턴 적용 */
    @Test
    void strategyV1() {
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    /** 익명 내부 클래스. (바로 구현체 넣어버리기.!) */
    @Test
    void strategyV2() {
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직1 실행"); }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직2 실행"); }
        });
    }

    /** 람다 사용 */
    @Test
    void strategyV3() {
        ContextV2 context = new ContextV2();
        context.execute(() -> log.info("비즈니스 로직1 실행"));
        context.execute(() -> log.info("비즈니스 로직2 실행"));
    }


}
