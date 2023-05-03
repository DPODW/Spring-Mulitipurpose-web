package com.multipurpose.web.service.boardservice.impl;

import com.multipurpose.web.repository.boardrepository.BoardRepository;
import com.multipurpose.web.service.boardservice.BoardService;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public void writeInsert(Board board) {
        boardRepository.boardInsert(board);
    }
}
