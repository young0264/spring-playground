package spring.playground.proxy.pureproxy.proxy.common.advice;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class TimeAdvice implements MethodInterceptor {

    /**
     * target - class 정보는 invocation 에 모두 포함되어있음.
     * */
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        log.info("TimeProxy 실행");
        long startTime = System.currentTimeMillis();

        Object result = invocation.proceed(); /**  */

        long endTime = System.currentTimeMillis();
        long resultTime = endTime - startTime;

        log.info("TimeProxy 종료 resultTime={}ms", resultTime);

        return result;
    }
}
