package spring.playground.basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 클래스 이름의 첫글자를 소문자로하여 스프링 컨테이너에 등록됨 or 직접 부여 가능
@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    // 생성자에 @Autowired를 지정
    // -> 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입함.
    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
