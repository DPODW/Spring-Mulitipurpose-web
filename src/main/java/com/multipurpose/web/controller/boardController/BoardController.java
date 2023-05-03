package com.multipurpose.web.controller.boardController;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/boards")
public class BoardController {


    @GetMapping("")
    public String writeBoard(){

        return "boards/BoardWrite";
    }

    @GetMapping("/board1")
    public String updateBoard(){

        return "boards/BoardUpdate";
    }

    @GetMapping("/board2")
    public String deleteBoard(){

        return "boards/BoardDelete";
    }

    /**
     * 접근 컨트롤러 구현 중
     * */
}
