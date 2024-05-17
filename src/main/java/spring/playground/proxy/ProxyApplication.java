package spring.playground.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import spring.playground.proxy.config.AppV1Config;

@Import(AppV1Config.class)
@SpringBootApplication(scanBasePackages = "spring.playground.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

}
