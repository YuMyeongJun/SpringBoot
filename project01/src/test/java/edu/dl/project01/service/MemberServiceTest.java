package edu.dl.project01.service;

import edu.dl.project01.domain.Member;
import edu.dl.project01.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value=true)
class MemberServiceTest {
    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;

    @Test
    public void joinMemberTest(){
        Member member = new Member();
        member.setId("mp");
        member.setName("Park");

        String savedId = memberService.join(member);
        System.out.println("##################" + savedId);
        Member member1 = memberRepository.findOne(savedId);
        System.out.println("##################" + member1.getId());

        assertEquals(savedId, member1.getId());
    }
}