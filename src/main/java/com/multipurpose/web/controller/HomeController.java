package com.multipurpose.web.controller;

import com.multipurpose.web.repository.SessionConst;
import com.multipurpose.web.service.LoginService;
import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final LoginController loginController;

    private final LoginService loginService;

    @GetMapping("")
    /**
     * 메인 화면 (로그아웃 됌. )
     * */
    public String home(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies.
        HttpSession session = request.getSession(false);
        return "homes/Homes";
    }


    @GetMapping("/home1")
    public String homes(HttpServletRequest request,LoginMember loginMember, Model model){
        HttpSession session = request.getSession(false);

        Object loginInfo = session.getAttribute(SessionConst.LOGIN_MEMBER);
        List<LoginMember> loginMembers = loginService.loginCheck((LoginMember) loginInfo);

        //현재 로그인 정보를 띄우기 위한 로직 . . . 서비스 쪽에 구현하는것이 좋을것 같다.
        LoginMember loginMember1 = loginMembers.get(0);
        loginMember.setLoginId(loginMember1.getLoginId());
        loginMember.setLoginPwd(loginMember1.getLoginPwd());
        
        model.addAttribute("id",loginMember.getLoginId());
        return "homes/Home1";
    }

}
