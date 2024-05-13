package spring.playground.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends AbstractTemplate{

    @Override
    protected void call() {
        log.info("[SubClassLogic2] 비즈니스 로직 2 실행함");
    }

}
