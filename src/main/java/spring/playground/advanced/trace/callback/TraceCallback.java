package spring.playground.advanced.trace.callback;

public interface TraceCallback<T> {
    T call();
}
