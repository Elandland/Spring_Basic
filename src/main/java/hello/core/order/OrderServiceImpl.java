package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDicountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy;
    //private final DiscountPolicy discountPolicy = new FixDicountPolicy();             //추상(인터페이스)에도 의존하고 구체(클래스)에도 의존하기 때문에 DIP위반
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();             //이 때문에 fixDis~ 에서 RateDis~로 바꿀때 OCP위반 (직접적 코드 변경)

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId, itemName, itemPrice,discountPrice);
    }
}
