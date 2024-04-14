package spring.playground.basic.order;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.playground.basic.discount.DiscountPolicy;
import spring.playground.basic.member.Member;
import spring.playground.basic.member.MemberRepository;

@Component
@RequiredArgsConstructor //final이 붙은 필드를 모아서 생성자를 자동생성해줌., 순서가 중요한 생성자 생성시에는 직접 생성. class파일에서 확인 가능
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    //생성자에 있는 파라미터들 모두 spring bean 저장소에 bean으로 등록해줌(component scan시)
    //생성자가 1개일시 @Autowired생략 가능
//    public OrderServiceImpl(MemberRepository memberRepository,
//                            DiscountPolicy discountPolicy) {  // 외부로부터 결정
//        this.memberRepository = memberRepository;
//        this.discountPolicy = discountPolicy;
//    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
