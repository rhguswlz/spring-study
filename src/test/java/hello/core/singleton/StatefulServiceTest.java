package hello.core.singleton;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ApplicationObjectSupport;


class StatefulServiceTest {

    private Object Assertions;

    @Test
    void statefulServiceSingleton() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        int userA_price = statefulService1.order("userA", 10000);
        int userB_price = statefulService2.order("userB", 20000);

        //int price = statefulService1.getPrice();
        //System.out.println("price = " + price);
        System.out.println("userA_price = " + userA_price);
        System.out.println("userB_price = " + userB_price);

        //assertThatefulService1.getPrice()).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();

        }
    }



}