package com.multipurpose.web.controller;

import com.multipurpose.web.service.JoinCheckService;
import com.multipurpose.web.vo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/userC")
public class JoinCheckController {
    /**
     * 아이디 중복 , 비밀번호 동일 여부 , 전화번호 형식  체크 하는 컨트롤러
     */
    private final JoinCheckService joinCheckService;



    @PostMapping("/id")
    public String idDuplicationCheck(@Validated
                                     @RequestParam("joinId") String joinId,
                                     @ModelAttribute JoinMember joinMember, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        boolean duplicationCheckId = joinCheckService.duplicateIdCheck(joinId);
        if (duplicationCheckId == true) {
            log.info("사용 가능한 아이디");
            redirectAttributes.addFlashAttribute("joinMember", joinMember);
            redirectAttributes.addFlashAttribute("joinId", joinId);
            return "redirect:/user/joins";
        } else {
            log.info("로그인 중복 실패입니다");
            bindingResult.rejectValue("joinId", "Duplicated.joinId");
            return "memberView/Join";
        }
    }


    @PostMapping("/pwd")
    public String pwdSameCheck(@Validated
                               @RequestParam("joinPwdCheck") String joinPwdCheck,
                               @ModelAttribute JoinMember joinMember, BindingResult bindingResult,
                               RedirectAttributes redirectAttributes) {
        boolean sameCheck = joinCheckService.comparePwdCheck(joinPwdCheck, joinMember.getJoinPwd());
        if (sameCheck == true) {
            redirectAttributes.addFlashAttribute("joinMember", joinMember);
            redirectAttributes.addFlashAttribute("joinPwdCheck", joinPwdCheck);
            return "redirect:/user/joins";
        } else {
            log.info("비밀번호가 동일하지 않습니다");
            bindingResult.rejectValue("joinPwdCheck", "NotSame.joinPwdCheck");
            return "memberView/Join";
        }
    }


    @PostMapping("/call")
    public String callDuplicationCheck(@Validated
                                       @RequestParam("joinCall") String joinCall,
                                       @ModelAttribute JoinMember joinMember, BindingResult bindingResult,
                                       RedirectAttributes redirectAttributes) {
        boolean duplicateCheckCall = joinCheckService.duplicateCallCheck(joinCall);
        if (duplicateCheckCall == true) {
            redirectAttributes.addFlashAttribute("joinMember", joinMember);
            redirectAttributes.addFlashAttribute("joinCall", joinCall);
            return "redirect:/user/joins";
        } else {
            log.info("전화번호가 동일하지 않습니다.");
            bindingResult.rejectValue("joinCall", "Duplicated.joinCall");
            return "memberView/Join";
        }
    }

}