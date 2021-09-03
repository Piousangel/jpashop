package jpabook.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter @Setter
public class Order {

    @Id @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne                        //다대일관계.
    @JoinColumn(name = "member_id")   // --> mapping을 뭘로 할거냐를 뜻하는 어노테이션. (FK)
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private LocalDateTime orderDate;  //주문시간.

    @Enumerated(EnumType.STRING)
    private OrderStatus status;      //주문상태를 말하는.. [Order, Cancel]
}
