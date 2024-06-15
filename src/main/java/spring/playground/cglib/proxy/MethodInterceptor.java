package spring.playground.cglib.proxy;

import org.springframework.cglib.proxy.MethodProxy;

import javax.security.auth.callback.Callback;
import java.lang.reflect.Method;

public interface MethodInterceptor extends Callback {
    Object intercept(Object obj, Method method, Object[] args, MethodProxy
            proxy) throws Throwable;
}
