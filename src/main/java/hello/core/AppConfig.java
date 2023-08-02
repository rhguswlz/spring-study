package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//appconfig가 공연기획자의 역할 (구현 객체를 생성하고, 연결)
@Configuration
public class AppConfig {

    //스프링 컨테이너에 스프링 빈으로 등록
    //메서드 명을 bean의 이름으로 등록 (@Bean(name="mmm") 도 가능)
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        //생성자주입
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //fix -> rate로 바꾸려면 여기만 바꾸면 됨
        //return new FixDicountPolicy();
        return new RateDiscountPolicy();
    }


}
