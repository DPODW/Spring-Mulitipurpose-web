package com.multipurpose.web.controller;


import com.multipurpose.web.repository.SessionConst;
import com.multipurpose.web.service.LoginService;
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
import java.util.NoSuchElementException;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping("/logins")
    public String loginForm(Model model){
        model.addAttribute("loginMember" ,new LoginMember());
        return "logins/Login";
    }


      @PostMapping("/logins")
      public String login(@Validated @ModelAttribute LoginMember loginMember, BindingResult bindingResult, Model model,HttpServletRequest request ){
        if(!loginService.loginCheck(loginMember).isEmpty()){
            HttpSession session = request.getSession();
            session.setAttribute(SessionConst.LOGIN_MEMBER,loginMember);
            model.addAttribute("id",loginMember.getLoginId());
            log.info("로그인 성공");
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
