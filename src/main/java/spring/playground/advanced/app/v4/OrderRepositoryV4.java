package spring.playground.advanced.app.v4;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring.playground.advanced.trace.TraceId;
import spring.playground.advanced.trace.TraceStatus;
import spring.playground.advanced.trace.logtrace.LogTrace;
import spring.playground.advanced.trace.template.AbstractTemplate;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {

        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                //저장 로직
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("예외 발생!"); }
                sleep(1000);
                return null;
            }
        };

        template.execute("OrderRepository.save()");

//        TraceStatus status = null;
//        try {
//            status = trace.begin("OrderRepository.save()");
//
//            //저장로직
//            if (itemId.equals("ex")) {
//                throw new IllegalStateException("=== 예외 발생===");
//            }
//            sleep(1000);
//            trace.end(status);
//        } catch (Exception e) {
//            trace.exception(status, e);
//            throw e;
//        }
    }

    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
