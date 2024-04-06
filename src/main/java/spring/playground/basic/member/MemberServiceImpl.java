package spring.playground.basic.member;

import lombok.NoArgsConstructor;

public class MemberServiceImpl implements MemberService{

    //TODO : 추후 리팩토링 부분이겟찌
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

}
