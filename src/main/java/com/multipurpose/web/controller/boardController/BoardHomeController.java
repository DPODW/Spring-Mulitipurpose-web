package com.multipurpose.web.controller.boardController;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/boardHome")
public class BoardHomeController {

    @GetMapping("")
    public String boardHome(){

        return "boards/BoardHome";
    }

}
