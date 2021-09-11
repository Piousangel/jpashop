package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)                    //JPA의 모든 데이터 변경,logic들은 transaction안에서 실행되어야 한다. @AllArgsConstructor @RequiredArgsConstructor
@RequiredArgsConstructor                           //final로 잡은 것들만 생성자를 만들어준다.
public class MemberService {

             //autowired 어노테이션을 써 바로 인젝션시킨다.(Spring이 Spring bean에 등록되어있는 memberRepository를 밑저기에 injection해준다.
    private final MemberRepository memberRepository;

//    @Autowired     //setterInjection방법.   --> 요새는 생성자 injection을 많이 쓴다고함.
////    public void setMemberRepository(MemberRepository memberRepository){
////        this.memberRepository = memberRepository;
////    }

//    @Autowired
//    public MemberService(MemberRepository memberRepository){
//        this.memberRepository = memberRepository;
//    }

    //회원 가입
    @Transactional
    public Long join(Member member){

        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    //회원 전체 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
    //단일 회원 조회
    public Member findOne(Long memberId){
        return memberRepository.findOne(memberId);
    }
}
