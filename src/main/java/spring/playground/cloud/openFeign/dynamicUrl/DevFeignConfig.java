package spring.playground.cloud.openFeign.dynamicUrl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevFeignConfig {

    @Bean
    public FeignConfigEnv feignConfigEnv() {
        return new FeignConfigEnv("http://{개발계url}");
    }

}
