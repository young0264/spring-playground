package spring.playground.advanced.trace.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.playground.advanced.trace.template.code.AbstractTemplate;
import spring.playground.advanced.trace.template.code.SubClassLogic1;
import spring.playground.advanced.trace.template.code.SubClassLogic2;

@Slf4j
public class TemplateMethodTest {

    @Test
    void templateMethodV2() {
        AbstractTemplate abstractTemplate1 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직1 실행");
            }
        };
        log.info("클래스 이름1 : {} ", abstractTemplate1.getClass());
        abstractTemplate1.execute();

        AbstractTemplate abstractTemplate2 = new AbstractTemplate() {
            @Override
            protected void call() {
                log.info("비즈니스 로직2 실행");
            }
        };
        log.info("클래스 이름2 : {} ", abstractTemplate2.getClass());
        abstractTemplate2.execute();
    }

    @Test
    void templateMethodV1() {
        SubClassLogic1 subClassLogic1 = new SubClassLogic1();
        subClassLogic1.execute();

        SubClassLogic2 subClassLogic2 = new SubClassLogic2();
        subClassLogic2.execute();

    }

    @Test
    void templateMethodV0() {
        logic1();
        logic2();
    }

    private void logic1() {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행(exam)
        log.info("비즈니스 로직1 실행");
        //비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);
    }

    private void logic2() {
        long startTime = System.currentTimeMillis();

        //비즈니스 로직 실행(exam)
        log.info("비즈니스 로직2 실행");
        //비즈니스 로직 종료

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;
        log.info("resultTime = {}", resultTime);

    }
}
