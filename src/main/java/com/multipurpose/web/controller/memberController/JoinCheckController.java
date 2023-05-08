package com.multipurpose.web.controller.memberController;

import com.multipurpose.web.service.memberservice.JoinCheckService;
import com.multipurpose.web.vo.membervo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static com.multipurpose.web.controller.memberController.FlashData.*;


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
                                     @ModelAttribute JoinMember joinMember,RedirectAttributes redirectAttributes
    ) {
        boolean duplicationCheckId = joinCheckService.duplicateIdCheck(joinId);
        if(duplicationCheckId == true) {
            flashDataMember(joinMember, redirectAttributes);
            flashDataId(joinId,redirectAttributes);
            return "redirect:/user/joins";
        } else {
            flashDataMember(joinMember, redirectAttributes);
            flashDataIdFail(joinId,redirectAttributes);
            return "redirect:/user/joins";
        }
    }

    @PostMapping("/pwd")
    public String pwdSameCheck(@Validated
                               @RequestParam("joinPwdCheck") String joinPwdCheck,
                               @ModelAttribute JoinMember joinMember,
                               RedirectAttributes redirectAttributes) {
        boolean sameCheck = joinCheckService.comparePwdCheck(joinPwdCheck, joinMember.getJoinPwd());
        if (sameCheck == true) {
            flashDataMember(joinMember, redirectAttributes);
            flashDataPwd(joinPwdCheck, redirectAttributes);
            return "redirect:/user/joins";
        } else {
            flashDataMember(joinMember, redirectAttributes);
            flashDataPwdFail(joinPwdCheck, redirectAttributes);
            return "redirect:/user/joins";
        }
    }


    @PostMapping("/call")
    public String callDuplicationCheck(@Validated
                                       @RequestParam("joinCall") String joinCall,
                                       @ModelAttribute JoinMember joinMember,
                                       RedirectAttributes redirectAttributes) {
        boolean duplicateCheckCall = joinCheckService.duplicateCallCheck(joinCall);
        if(duplicateCheckCall == true) {
            flashDataMember(joinMember, redirectAttributes);
            flashDataCall(joinCall, redirectAttributes);
            return "redirect:/user/joins";
        } else {
            log.info("전화번호가 중복.");
            flashDataMember(joinMember, redirectAttributes);
            flashDataCallFail(joinCall,redirectAttributes);
            return "redirect:/user/joins";
        }
    }
}