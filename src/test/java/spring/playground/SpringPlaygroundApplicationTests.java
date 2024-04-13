package spring.playground;

import io.micrometer.common.lang.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import spring.playground.basic.member.Member;

import java.util.Optional;

@SpringBootTest
class SpringPlaygroundApplicationTests {

	@Test
	void contextLoads() {
	}

	//호출 안됨
	@Autowired(required = false)
	public void setNoBean1(Member member) {
		System.out.println("setNoBean1 = " + member);
	}
	//null 호출
	@Autowired
	public void setNoBean2(@Nullable Member member) {
		System.out.println("setNoBean2 = " + member);
	}
	//Optional.empty 호출
	@Autowired(required = false)
	public void setNoBean3(Optional<Member> member) { //Optional 안티패턴
		System.out.println("setNoBean3 = " + member);
	}


}
