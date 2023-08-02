package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//-> @Component 가 달려있는 클래스 스캔해서 알아서 bean 으로 등록
// (@Configuration 도 디컴파일해서 보면 결국 @Component 달려있기 때문에 bean 등록될까봐 appconfig 예제 유지를 위해 빼줬음)
@ComponentScan(
        basePackages = "hello.core" , //이 패키지부터 찾아서 스캔하라 (이게 없으면 모든거 다뒤져봐서 오래걸림)
        basePackageClasses = AutoAppConfig.class, //지정한 클래스의 패키지를 탐색 시작 위치로 지정한다.
                    // (지정안하면 @ComponentScan 이 붙은 설정 정보 클래스의 패키지가 시작 위치)
                   //basePackage를 지정하기보단 요 AutoAppConfig 파일을 루트에 둬서 스캔하도록 만들자
        //스프링 부트의 대표 시작 정보인 @SpringBootApplication 를 이 프로젝트 시작 루트 위치에 두는 것이 관례이다.
        // (그리고 이 설정안에 바로 @ComponentScan 이 들어있다!) 즉, SpringBootApplication 쓰면 여기부터 스캔하게 될 것
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {
}
//컴포넌트 스캔은 @Component 뿐만 아니라 다음과 내용도 추가로 대상에 포함한다.
//@Component : 컴포넌트 스캔에서 사용
//@Controller : 스프링 MVC 컨트롤러에서 사용
//@Service : 스프링 비즈니스 로직에서 사용 / 특별한 처리를 하지 않지만 개발자들이 핵심 비즈니스 로직이 여기에 있겠구나 라고 비즈니스 계층을 인식하는데 도움
//@Repository : 스프링 데이터 접근 계층에서 사용 / 스프링 데이터 접근 계층으로 인식하고, 데이터 계층의 예외를 스프링 예외로 변환
//@Configuration : 스프링 설정 정보에서 사용 / 스프링 빈이 싱글톤을 유지하도록 추가 처리
