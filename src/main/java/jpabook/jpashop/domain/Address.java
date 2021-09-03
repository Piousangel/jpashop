package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable               //내장타입이기때문에 임베더블 어노테이션 해준다.
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;
}