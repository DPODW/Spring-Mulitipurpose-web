package com.multipurpose.web.controller.memberController;


import com.multipurpose.web.repository.memberrepository.SessionConst;
import com.multipurpose.web.service.memberservice.LoginService;
import com.multipurpose.web.vo.membervo.LoginMember;
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
@RequestMapping("login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/logins")
    public String loginForm(Model model,HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            log.info("loginForm 세션 삭제");
        }else {
            log.info("loginForm 세션 이미 삭제되었거나 없습니다.");
        }
        model.addAttribute("loginMember" ,new LoginMember());
        return "logins/Login";
    }


      @PostMapping("/logins")
      public String login(@Validated @ModelAttribute LoginMember loginMember, BindingResult bindingResult, Model model,HttpServletRequest request ){
        if(!loginService.loginCheck(loginMember).isEmpty()){
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);
            model.addAttribute("id",loginMember.getLoginId());
            return "homes/Home1";
        }else{
           log.info("아이디 없음");
           bindingResult.reject("loginFail");
           log.info("{}",bindingResult);
           return "logins/Login";
        }
    }


    @PostMapping ("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
            log.info("세션 정상 삭제");
        }else {
            log.info("세션이 이미 삭제되었거나 없습니다.");
        }
        return "redirect:/home";
    }

}
