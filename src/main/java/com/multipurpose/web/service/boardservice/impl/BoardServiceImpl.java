package com.multipurpose.web.service.boardservice.impl;

import com.multipurpose.web.repository.boardrepository.BoardRepository;
import com.multipurpose.web.service.boardservice.BoardService;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;


    @Override
    public void writeInsert(Board board) {
        boardRepository.boardInsert(board);
    }


    @Override
    public void writeUpdate(Board board) {
        boardRepository.boardUpdate(board);
    }
}
