package jpabook.jpashop;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


@RunWith(SpringRunner.class)   //스프링과 관련된 것을 Test한다고 알려줘야 함.
@SpringBootTest
public class MemberRepositoryTest {

    @Autowired MemberRepository memberRepository;

    //entity manager를 통한 모든 데이터 변경은 항상 Transaction안에서 이루어져야 합니다.

    @Test
    @Transactional        //transactional 어노테이션이 testcase 안에 있으면 수행하고 바로 DB를 롤백 해버린다고함.
    @Rollback(false)
    public void testMember() throws Exception {

        //given
        Member member = new Member();
        member.setUsername("memberA");

        //when
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);

        //then
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getUsername()).isEqualTo(member.getUsername());

        //Assertions.assertThat(findMember).isEqualTo(member);
        //System.out.println("findMember == member :" +(findMember == member));
        //같은 트랜잭션안에서 저장하고 조회하면 영속성 컨텍스트가 똑같음. 같은 영속성 컨텍스트 안에서는 id값이 같으면 같은 entity로 식별한다. by 1차 캐시.
        //java -jar으로도 test 가능합니다.



    }
}