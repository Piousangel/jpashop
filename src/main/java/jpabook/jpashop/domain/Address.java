package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable               //내장타입이기때문에 임베더블 어노테이션 해준다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;


    //값 타입은 변경 불가능하게 설계해야한다.(생성자에서 값을 모두 초기화해서 변경 불가능한 클래스를 만들자.)
    protected Address(){

    }

    public Address(String city, String street, String zipcode){
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
