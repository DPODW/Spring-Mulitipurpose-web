package com.multipurpose.web.repository.boardrepository;

import com.multipurpose.web.vo.boardvo.Board;

import java.util.List;

public interface FindBoardRepository {

    List<Board> findAll (Board board);
}
