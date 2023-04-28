package com.multipurpose.web.service.boardservice;

import com.multipurpose.web.vo.boardvo.Board;

import java.util.List;

public interface BoardFindService {
    List<Board> findAll (Board board);
}
