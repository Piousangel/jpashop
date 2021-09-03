package jpabook.jpashop.domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue   //sequence값 같은 것 쓸 수 있다.
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")     //일대다 관계  mappedby -> 읽기전용.
    private List<Order> orders = new ArrayList<>();
}
