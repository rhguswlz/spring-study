package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

public class FixDicountPolicy implements DiscountPolicy{

    private int discountFixAmount = 1000; //1000원 정액할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmount;
        } else {
            return 0;
        }
    }
}
