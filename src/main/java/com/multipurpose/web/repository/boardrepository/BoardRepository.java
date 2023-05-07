package com.multipurpose.web.repository.boardrepository;

import com.multipurpose.web.vo.boardvo.Board;

public interface BoardRepository {

    Board boardInsert(Board board);

    void boardUpdate(Board board);

    void boardDelete(Integer number);
}
