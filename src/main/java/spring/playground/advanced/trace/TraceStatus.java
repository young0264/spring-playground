package spring.playground.advanced.trace;

/**
 * 로그의 상태 정보를 나타내는 클래스
 *     traceId      : 트랜잭션ID, depth level
 *     startTimeMs  : 로그 시작시간
 *     message      : 시작시 사용한 메시지
 **/
public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs;
    private String message;

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

}