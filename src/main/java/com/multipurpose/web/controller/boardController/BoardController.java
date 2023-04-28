package com.multipurpose.web.controller.boardController;


import com.multipurpose.web.repository.memberrepository.SessionConst;
import com.multipurpose.web.service.boardservice.BoardService;
import com.multipurpose.web.vo.boardvo.Board;
import com.multipurpose.web.vo.membervo.LoginMember;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/boards")
public class BoardController {
    private final BoardService boardService;

    /**
     * 접근 컨트롤러
     * */
    @GetMapping("")
    public String writeBoardForm(HttpServletRequest request, Model model){
        HttpSession session = request.getSession(false);
        LoginMember writerInfo = (LoginMember) session.getAttribute(SessionConst.LOGIN_MEMBER);
        model.addAttribute("id",writerInfo);
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



    @PostMapping("")
    public String writeBoard(@ModelAttribute Board board, Model model){
        boardService.writeInsert(board);
        return "redirect:/boardHome";
    }


}
