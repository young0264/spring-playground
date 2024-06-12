package spring.playground.cloud.openFeign.dynamicUrl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("local")
public class LocalFeignConfig {

    @Bean
    public FeignConfigEnv feignConfigEnv() {
        return new FeignConfigEnv("http://localhost:8080/notificator/api/sse/v1");
    }

}

