package com.multipurpose.web.service;

import com.multipurpose.web.repository.FindMemberRepository;
import com.multipurpose.web.vo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class JoinCheckService {

    private final FindMemberRepository findMemberRepository;

    public List<JoinMember> duplicationCheck(String duplicateId){
        List<JoinMember> checkMember = findMemberRepository.findDuplicateId(duplicateId);
        log.info("{}",checkMember.toString());
        return checkMember;
    }
}
