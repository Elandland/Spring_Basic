package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //구현 클래스 말고 인터페이스에 의존해야함
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long MemberId) {
        return memberRepository.findById(MemberId);
    }
}
