package com.multipurpose.web.service;

import com.multipurpose.web.repository.FindMemberRepository;
import com.multipurpose.web.repository.MemberRepository;
import com.multipurpose.web.vo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Slf4j
@Service
public class JoinCheckService {

    private final FindMemberRepository findMemberRepository;

    public void duplicationCheck(String duplicateId){
        List<JoinMember> checkMember = findMemberRepository.findDuplicateId(duplicateId);
        if(checkMember.isEmpty()){
            log.info("사용 가능한 아이디 입니다.");
        }else{
            log.info("중복된 아이디 입니다.");
            throw new NoSuchElementException("중복된 아이디 예외 발생");
        }
    }
}
