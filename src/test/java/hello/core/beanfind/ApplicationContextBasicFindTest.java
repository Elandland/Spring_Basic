package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);         //memberservice가 memberserviceImpl의 인스턴스면 참
    }
    @Test
    @DisplayName("빈 타입으로 조회(이름 x)")
    void findBeanByType(){
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);         //memberservice가 memberserviceImpl의 인스턴스면 참
    }
    @Test
    @DisplayName("구체 타입으로 조회(인터페이스x)")
    void findBeanByName2(){
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);         //memberservice가 memberserviceImpl의 인스턴스면 참
    }

    @Test
    @DisplayName("빈 이름 조회 실패 상황")       //항상 test는 실패할 경우도 포함해야 함
    void findBeanByNameX(){
        //  MemberService xxxxx = ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, () ->       //이 오류가 떠야 함
                ac.getBean("xxxxx", MemberService.class));      //이 로직을 실행했을때
    }

}
