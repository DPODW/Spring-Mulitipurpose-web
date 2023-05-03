package com.multipurpose.web.controller.memberController;

import com.multipurpose.web.service.memberservice.JoinCheckService;
import com.multipurpose.web.service.memberservice.MemberService;
import com.multipurpose.web.vo.membervo.JoinMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/userU")
public class UpdateCheckController {

    private MemberService memberService;
    private final JoinCheckService joinCheckService;

    @PostMapping("/pwd")
    public String pwdSameCheck(@Validated
                               @RequestParam("joinPwdCheck") String updatePwdCheck,
                               @ModelAttribute JoinMember idMember,
                               RedirectAttributes redirectAttributes) {
        if (joinCheckService.comparePwdCheck(updatePwdCheck, idMember.getJoinPwd()) == true) {
            redirectAttributes.addFlashAttribute("updatePwdCheck", updatePwdCheck);
        } else {
            redirectAttributes.addFlashAttribute("UpdatePwdCheckFail", updatePwdCheck);
        }
        redirectAttributes.addFlashAttribute("idMember", idMember);
        return "redirect:/user/member1?form";
    }



    @PostMapping("/call")
    public String callDuplicationCheck(@Validated
                                       @RequestParam("joinCall") String updateCall,
                                       @ModelAttribute JoinMember idMember,
                                       RedirectAttributes redirectAttributes) {
        if(joinCheckService.duplicateCallCheck(updateCall) == true || joinCheckService.existingCallPermitCheck(idMember.getJoinId(),updateCall) == true) {
            redirectAttributes.addFlashAttribute("joinCall", updateCall);
        } else {
            redirectAttributes.addFlashAttribute("joinCallFail", updateCall);
        }
        redirectAttributes.addFlashAttribute("idMember", idMember);
        return "redirect:/user/member1?form";
    }

}
