package spring.playground.proxy.trace.callback;

public interface TraceCallback<T> {
    T call();
}
