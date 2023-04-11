package com.multipurpose.web.controller;

import com.multipurpose.web.repository.MemberRepository;
import com.multipurpose.web.service.JoinCheckService;
import com.multipurpose.web.vo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/userC")
public class JoinCheckController {
/**
 * 아이디 중복 , 비밀번호 동일 여부 , 전화번호 형식  체크 하는 컨트롤러
 * */
    private final JoinCheckService joinCheckService;

    @PostMapping("/id")
    public void idDuplicationCheck(@RequestParam("joinId") String duplicateId){
        joinCheckService.duplicationCheck(duplicateId);
    }
}
