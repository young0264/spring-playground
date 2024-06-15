package spring.playground.aopalliance.intercept;

import org.aopalliance.intercept.MethodInvocation;
import org.hibernate.Interceptor;

public interface MethodInterceptor extends Interceptor {
    Object invoke(MethodInvocation invocation) throws Throwable;
}
