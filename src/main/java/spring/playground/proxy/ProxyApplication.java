package spring.playground.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import spring.playground.proxy.config.AppV1Config;
import spring.playground.proxy.config.v1_proxy.InterfaceProxyConfig;
import spring.playground.proxy.trace.logtrace.LogTrace;
import spring.playground.proxy.trace.logtrace.ThreadLocalLogTrace;

//@Import(AppV1Config.class)
@Import(InterfaceProxyConfig.class)
@SpringBootApplication(scanBasePackages = "spring.playground.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean // LogTrace bean 등록
	public LogTrace logTrace() {
		return new ThreadLocalLogTrace();
	}

}
