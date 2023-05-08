package com.multipurpose.web.controller.memberController;


import com.multipurpose.web.vo.membervo.JoinMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Slf4j
public class FlashData {
    /**
     * 검증으로 인한 새로고침(redirect) 시, 기존에 입력된 값들을 다시 뿌려주는 class
     * */

    /** joinCheckController 전용 flashData*/
    protected static void flashDataMember(JoinMember joinMember, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinMember", joinMember);
    }

    protected static void flashDataId(String joinId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinId", joinId);
    }

    protected static void flashDataIdFail(String joinId, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinIdFail", joinId);
    }

    protected static void flashDataPwd(String joinPwdCheck, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinPwdCheck", joinPwdCheck);
    }

    protected static void flashDataPwdFail(String joinPwdCheck, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinPwdCheckFail", joinPwdCheck);
    }

    protected static void flashDataCall(String joinCall, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinCall", joinCall);
    }

    protected static void flashDataCallFail(String joinCall, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinCallFail", joinCall);
    }

    /** UpdateCheckController 전용 flash Data */

    protected static void UFlashDataPwd (String updatePwdCheck, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("updatePwdCheck", updatePwdCheck);
    }

    protected static void UFlashDataPwdFail (String updatePwdCheck, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("UpdatePwdCheckFail", updatePwdCheck);
    }

    protected static void UFlashDataCall(String updateCall, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinCall", updateCall);
    }

    protected static void UFlashDataCallFail(String updateCall, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("joinCallFail", updateCall);
    }

    protected static void flashDataIdMember(JoinMember idMember, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("idMember", idMember);
    }
}