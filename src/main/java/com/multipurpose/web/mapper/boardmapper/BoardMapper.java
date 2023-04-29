package com.multipurpose.web.mapper.boardmapper;

import com.multipurpose.web.vo.boardvo.Board;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Board board = new Board();
        board.setNumber(rs.getInt("number"));
        board.setTitle(rs.getString("title"));
        board.setContent(rs.getString("content"));
        board.setId(rs.getString("id"));
        return board;
    }
}
