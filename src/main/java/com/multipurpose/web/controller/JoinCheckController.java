package com.multipurpose.web.controller;

import com.multipurpose.web.repository.MemberRepository;
import com.multipurpose.web.service.JoinCheckService;
import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    public String idDuplicationCheck(@Validated @ModelAttribute JoinMember joinMember,BindingResult bindingResult, Model model) {
        List<JoinMember> duplicationCheckId = joinCheckService.duplicationCheck(joinMember.getJoinId());
        log.info("{}",duplicationCheckId);
        if(duplicationCheckId.size()==0){
            log.info("사용 가능한 아이디");
            model.addAttribute("joinMemberId",joinMember.getJoinId());
            return "memberView/Join";
        }else
            bindingResult.rejectValue("joinId","Duplicated.joinId");
            return "memberView/Join";
    }
}
