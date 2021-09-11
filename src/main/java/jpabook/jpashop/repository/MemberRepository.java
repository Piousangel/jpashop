package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository       //Spring이 Spring bean으로 등록해줌.
@RequiredArgsConstructor
public class MemberRepository {

                                //@PersistenceContext   // @PersistenceContext가 있으면 JPA의 entityManager를 스프링이 생성한 entitymanager을 여기 밑에 주입해줌.
    private final EntityManager em;

//    public MemberRepository(EntityManager em){       //Springboot api가 @persistencecontext가 수행할 것을 @AutoWired로 쓰게 지원해줘서 결국 @RequiredArgsConstructor를 사용할 수 있음.
//        this.em = em;
//    }

    public void save(Member member){
        em.persist(member);                   //persist사용하면 영속성 context에 맴버객체를 넣고 -> 트랜잭션이 커밋되는 시점에 DB에 반영이 된다.
    }

    public Member findOne(Long id){
        //Member member = me.find(Member.class, id);
        return em.find(Member.class, id);             //첫번째 type, 두번째 pk.
    }

    public List<Member> findAll(){
//        List<Member> result = em.createQuery("select m from Member m", Member.class) //첫번째 jpql, 두번째가 반환타입(조회타입?).
////                .getResultList();
////        return result;
        return em.createQuery("select m from Member m", Member.class)      //from의 대상이 table이 아니라 entity가 된다.
                    .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
