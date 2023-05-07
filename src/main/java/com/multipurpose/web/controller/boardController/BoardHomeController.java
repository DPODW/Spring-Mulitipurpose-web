package com.multipurpose.web.controller.boardController;


import com.multipurpose.web.repository.memberrepository.SessionConst;
import com.multipurpose.web.service.boardservice.BoardFindService;
import com.multipurpose.web.vo.boardvo.Board;
import com.multipurpose.web.vo.membervo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/boardHome")
public class BoardHomeController {

    private final BoardFindService boardFindService;

    @GetMapping("")
    public String boardHome(Board board, Model model, HttpServletRequest request){
        HttpSession session = request.getSession(false);
        LoginMember writerInfo = (LoginMember) session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("writerInfo",writerInfo.getLoginId());

        List<Board> boardList = boardFindService.findAll(board);
        model.addAttribute("boardList", boardList);
        return "boards/BoardHome";
    }


    @GetMapping("/board/{number}")
    public String boardContent(@PathVariable("number") Integer number, Model model){
        log.info("{}",number);
        List<Board> allContentList = boardFindService.findContent(number);
        Board allContent = allContentList.get(0);
        model.addAttribute("allContent",allContent);
        return "boards/BoardContent";
    }

}
