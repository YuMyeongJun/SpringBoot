package edu.dl.project01.service;

import edu.dl.project01.domain.Member;
import edu.dl.project01.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class MemberService {
    @Autowired
    private MemberRepository memberRepository;

    @Transactional(readOnly = false)
    public String join(Member member){
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member){
        List<Member> findMembers = memberRepository.findById(member.getId());
        if(!findMembers.isEmpty()){
            throw new IllegalStateException("존재하는 회원");
        }
    }

    public List<Member> findMembers(){
        return memberRepository.findAll();
    }

    public Member findOne(String id){
        return memberRepository.findOne(id);
    }

}
