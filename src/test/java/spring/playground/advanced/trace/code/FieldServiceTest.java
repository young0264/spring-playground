package spring.playground.advanced.trace.code;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import spring.playground.advanced.trace.threadLocal.code.FieldService;

@Slf4j
public class FieldServiceTest {

    private FieldService fieldService = new FieldService();

    @Test
    void field() throws InterruptedException {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        log.info("======= before start thread ==========");
        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");
        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start(); //A실행
//        sleep(2000); //동시성 문제 발생 X

        //동시성 문제 발생함 O, fieldService.logic에 1000ms sleep 이 있음.
        // threadA가 끝나기 전 threadB가 시작하면서 fieldService.logic을 실행함. -> 조회가 다 userB로 초기화됨
        sleep(100);
        threadB.start();

        sleep(3000); //메인 스레드 종료 대기
        log.info("main exit");
    }

    private void sleep(int millis) {
        try{
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}