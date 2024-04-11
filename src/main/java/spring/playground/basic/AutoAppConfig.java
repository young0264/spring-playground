package spring.playground.basic;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes =
                Configuration.class)) // 미리 생성해둔 @Configuration관련 정보를 등록하지 않기 위해.
public class AutoAppConfig {
}