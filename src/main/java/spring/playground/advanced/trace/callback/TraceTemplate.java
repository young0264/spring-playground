package spring.playground.advanced.trace.callback;

import spring.playground.advanced.trace.TraceStatus;
import spring.playground.advanced.trace.logtrace.LogTrace;

/**
 * 템플릿 역할
 * TraceCallback (callback)을 전달받음
 * <T> 제네릭을 사용, 반환 타입을 정의함
 * */
public class TraceTemplate {
    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message); //로직 호출
            T result = callback.call();
            trace.end(status);
            return result;
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }
    }

}
