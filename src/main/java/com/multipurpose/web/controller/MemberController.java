package com.multipurpose.web.controller;

import com.multipurpose.web.repository.SessionConst;
import com.multipurpose.web.service.MemberService;
import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {
     private final MemberService memberService;
     private final LoginController loginController;

    @GetMapping("/joins")
    public String joinForm(Model model){
        model.addAttribute("joinMember", new JoinMember());
        return "memberView/Join";
    }

    @GetMapping("/member1")
    public String memberUpdateForm(HttpServletRequest request, Model model){
        HttpSession session = request.getSession();
        Object sessionData = session.getAttribute(SessionConst.LOGIN_MEMBER);
        JoinMember updateMember = memberService.memberInfoView((LoginMember)sessionData);
        model.addAttribute("idMember",updateMember);
        log.info("{}",updateMember);
        return "memberView/MemberUpdate";
    }


    @GetMapping("/member2")
    public String memberDeleteForm(HttpServletRequest request, Model model){
    HttpSession session = request.getSession();
    Object sessionData = session.getAttribute(SessionConst.LOGIN_MEMBER);
    JoinMember deleteMember = memberService.memberInfoView((LoginMember)sessionData);
    model.addAttribute("idMember",deleteMember);
    return "memberView/MemberDelete";

    }


    @PostMapping("/joins")
    public String join(@Validated @ModelAttribute JoinMember joinMember,BindingResult bindingResult,Model model){
        log.info("회원가입 컨트롤러 호출");
        if(!bindingResult.hasErrors()){
            memberService.joinOk(joinMember);
            model.addAttribute(joinMember);
            return "memberView/member";
        }else {
            log.info("{}",bindingResult);
            return "memberView/Join";
        }
    }


    @PostMapping("/member1")
    public String memberUpdate(@Validated @ModelAttribute("idMember") JoinMember updateMember,BindingResult bindingResult ,Model model){
        if(!bindingResult.hasErrors()){
            JoinMember memberUpdate = memberService.memberUpdate(updateMember);
            model.addAttribute("idMember",memberUpdate);
            return "memberView/member";
        }else {
            log.info("{}",bindingResult);
            return "memberView/MemberUpdate";
        }
    }



    @PostMapping("/member2")
    public String memberDelete(@Validated @ModelAttribute JoinMember deleteMember,BindingResult bindingResult,HttpServletRequest request,Model model){
        memberService.memberDelete(deleteMember);
        return loginController.logout(request); //회원 삭제시, 해당 세션도 삭제
    }

}
