package spring.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import spring.playground.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import spring.playground.proxy.trace.logtrace.LogTrace;
import spring.playground.proxy.trace.logtrace.ThreadLocalLogTrace;

@Import(ProxyFactoryConfigV2.class)
//@SpringBootApplication
@SpringBootApplication(scanBasePackages = "spring.playground.proxy.app.v2") //주의
public class SpringPlaygroundApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlaygroundApplication.class, args);
	}

	@Bean // LogTrace bean 등록
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
