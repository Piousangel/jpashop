package jpabook.jpashop.domain;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id @GeneratedValue
    @Column(name = "category_id")
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(name = "category_item")     //객체는 collection이 있어서 다대다 관계가 가능하지만 관계형 Database는 Collection관계를 양쪽으로 가질 수 없어서 Jointable을 해줘야한다.(일대다, 다대일로 풀어야).
    private List<Item> items = new ArrayList<>();

}