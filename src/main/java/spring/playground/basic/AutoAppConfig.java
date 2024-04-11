package spring.playground.basic;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import spring.playground.basic.member.MemberRepository;
import spring.playground.basic.member.MemoryMemberRepository;

@Controller
@Service
@Repository //스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환해준다. -> 어디에서 하는거지
@Configuration
@ComponentScan(
        //탐색할 패키지 시작 위치를 지정(이 패키지를 포함하여 하위 패키지 탐색),
        //미지정시 @ComponentScan이 붙은 설정 정보 클래스의 패키지가 시작 위치가 됨
        basePackages = "spring.playground",
        excludeFilters = @Filter(
                type = FilterType.ANNOTATION,
                classes = Configuration.class)) // 미리 생성해둔 @Configuration관련 정보를 등록하지 않기 위해.
public class AutoAppConfig {

    @Bean(name = "memoryMemberRepository") // 수동빈이 우선권을 가져서 자동빈을 오버라이딩 해버림.
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }
}