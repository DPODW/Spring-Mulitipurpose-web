package com.multipurpose.web.service.memberservice.impl;

import com.multipurpose.web.repository.memberrepository.FindMemberRepository;
import com.multipurpose.web.service.memberservice.JoinCheckService;
import com.multipurpose.web.vo.membervo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class JoinCheckServiceImpl implements JoinCheckService {

    private final FindMemberRepository findMemberRepository;

    @Override
    public boolean duplicateIdCheck(String duplicateId){
        List<JoinMember> checkId = findMemberRepository.findDuplicateId(duplicateId);
        if(checkId.size()==0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean comparePwdCheck(String userPwd , String samePwd){
       return userPwd.equals(samePwd) && StringUtils.hasText(samePwd);
    }

    @Override
    public boolean duplicateCallCheck(String duplicatedCall) {
        List<JoinMember> checkCall = findMemberRepository.findDuplicateCall(duplicatedCall);
        if (checkCall.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean existingCallPermitCheck(String existingCallId,String updateCall) {
        List<JoinMember> beforeCallNumber = findMemberRepository.findCallById(existingCallId);
        JoinMember extractedCall = (JoinMember) beforeCallNumber.get(0);
        String joinCall = extractedCall.getJoinCall();
        if(joinCall.equals(updateCall)){
            return true;
        }else{
            return false;
        }
    }

}
