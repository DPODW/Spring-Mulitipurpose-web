package com.multipurpose.web.controller.boardController;


import com.multipurpose.web.service.boardservice.BoardFindService;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/boardHome")
public class BoardHomeController {

    private final BoardFindService boardFindService;

    @GetMapping("")
    public String boardHome(Board board, Model model){
        List<Board> boardList = boardFindService.findAll(board);
        model.addAttribute("boardList", boardList);
        return "boards/BoardHome";
    }


    @GetMapping("/board/{title}")
    public String boardContent(@PathVariable("title") String title, Model model){
        log.info("{}",title);
        List<Board> allContentList = boardFindService.findContent(title);
        Board allContent = allContentList.get(0);
        model.addAttribute("allContent",allContent);
        return "boards/BoardContent";
    }

}
