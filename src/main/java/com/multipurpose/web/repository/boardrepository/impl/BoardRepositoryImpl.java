package com.multipurpose.web.repository.boardrepository.impl;

import com.multipurpose.web.repository.boardrepository.BoardRepository;
import com.multipurpose.web.vo.boardvo.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public BoardRepositoryImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Board boardInsert(Board board) {
        String queryInsert = "insert into board(id,title,content)values(?,?,?)";
        Object[] args = {board.getId(), board.getTitle(), board.getContent()};
        jdbcTemplate.update(queryInsert,args);
        return board;
    }

    @Override
    public Board boardUpdate(Board board) {
        return null;
    }

    @Override
    public void boardDelete(Board board) {

    }
}
