package com.multipurpose.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeController {

    private final LoginController loginController;

    @GetMapping("")
    /**
     * 메인 화면 (로그아웃 됌. )
     * */
    public String home(HttpServletRequest request, HttpServletResponse response){
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setHeader("Expires", "0"); // Proxies.
        loginController.logout(request);
        return "homes/Homes";
    }


    @GetMapping("/home1")
    public String homes(){
        return "homes/Home1";
        /**
         * 로그인 한 이용자만 볼수 있는 화면.
         * 로그인 정보를 가져오는 Http 관련 속성이 구현되어있지 않음
         * 구현 해야함
         * ex) 수정 완료 시 -> 해당 화면으로 바로 전송(정보 가진 채로)
         * */
    }

}
