package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    void basicScan() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);

        // 1. @ComponentScan : @Component 가 붙은 모든 클래스를 스프링 빈으로 등록한다.
        //  ㄴ 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용한다. MemberServiceImpl 는 memberServiceImpl
        // 2. @Autowired 의존관계 자동 주입 :  @Autowired 를 지정하면, 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입
        //  ㄴ 타입이 같은 빈을 찾아서 주입한다. getBean(MemberRepository.class) 와 동일

    }
}
