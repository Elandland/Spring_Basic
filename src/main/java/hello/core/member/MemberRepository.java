package hello.core.member;


//interface랑 구현체는 다른 패키지에 존재하는게 설계상 좋음
public interface MemberRepository {

    void save(Member member);

    Member findById(Long MemberId);
}
