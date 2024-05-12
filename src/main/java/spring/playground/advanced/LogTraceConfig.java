package spring.playground.advanced;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.playground.advanced.trace.logtrace.FieldLogTrace;
import spring.playground.advanced.trace.logtrace.LogTrace;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace() {
        return new FieldLogTrace();
    }

}
