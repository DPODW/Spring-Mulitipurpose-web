package com.multipurpose.web.service.impl;


import com.multipurpose.web.repository.FindMemberRepository;
import com.multipurpose.web.repository.impl.MemberRepositoryImpl;
import com.multipurpose.web.service.MemberService;
import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberRepositoryImpl memberRepository;
    private final FindMemberRepository findMemberRepository;
    private final JoinMember joinMember;


    @Override
    public void joinOk(JoinMember joinMember){
        memberRepository.insert(joinMember);
    }

    @Override
    public JoinMember memberUpdate(JoinMember updateMember){
        memberRepository.update(updateMember);
        return updateMember;
    }

    @Override
    public void memberDelete(JoinMember deleteMember){
            memberRepository.delete(deleteMember);
    }

    @Override
    public JoinMember memberInfoView(LoginMember loginMember){
        List<JoinMember> updateMember = findMemberRepository.findMemberUseLoginInfo(loginMember);
        /**
         * JoinMember 가 List 타입이기 때문에, 인덱스 0(어차피 배열엔 JoinMember 하나 들어있음)
         * 을 선언해서 가져온다음, get set 해준다. (JoinMember member == public JoinMember[값이 들어있음] != joinMember[값이 없는 새로운 joinMember 임])
         * -> repository query 는 무조건 List 타입으로 반환하기 때문에 이렇게 대처해야 한다.
         * 
         * 추후에 다른 class 로 빼는것도 좋을듯
         * */
            JoinMember member = updateMember.get(0);
            joinMember.setJoinName(member.getJoinName());
            joinMember.setJoinId(member.getJoinId());
            joinMember.setJoinPwd(member.getJoinPwd());
            joinMember.setJoinCall(member.getJoinCall());

        return joinMember;
    }

}
