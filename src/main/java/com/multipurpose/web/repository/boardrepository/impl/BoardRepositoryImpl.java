package com.multipurpose.web.repository.boardrepository.impl;

import com.multipurpose.web.repository.boardrepository.BoardRepository;
import com.multipurpose.web.vo.boardvo.Board;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Slf4j
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
    public void boardUpdate(Board board) {
        String queryUpdate = "update board set content=?, title=? where id=?";
        Object[] args = {board.getContent(),board.getTitle(),board.getId()};
        jdbcTemplate.update(queryUpdate,args);
    }

    @Override
    public void boardDelete(String title) {
        String queryDelete = "delete from board where title=?";
        jdbcTemplate.update(queryDelete,title);
    }
}
