package com.multipurpose.web.service.boardservice.impl;

import com.multipurpose.web.repository.boardrepository.BoardRepository;
import com.multipurpose.web.repository.boardrepository.FindBoardRepository;
import com.multipurpose.web.service.boardservice.BoardFindService;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardFindServiceImpl implements BoardFindService {

    private final FindBoardRepository findBoardRepository;

    @Override
    public List<Board> findAll(Board board) {
        /** 확장 가능  */
        return findBoardRepository.findAll(board);
    }
}
