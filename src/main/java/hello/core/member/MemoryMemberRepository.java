package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//구현체랑 interface는 위치를 같은 패키지 말고 다른 곳에 두는것이 좋음
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long , Member> store = new HashMap<>();      //저장소니까 Map추가   사실 동시성 이슈 있을 수도 있어서 concurrenthashmap 써야됨

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);

    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
