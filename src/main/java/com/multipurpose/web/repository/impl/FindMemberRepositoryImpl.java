package com.multipurpose.web.repository.impl;

import com.multipurpose.web.mapper.JoinMapper;
import com.multipurpose.web.repository.FindMemberRepository;
import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class FindMemberRepositoryImpl implements FindMemberRepository {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public FindMemberRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public List<JoinMember> findById(String id) {
        String QueryFindById = "select * from member where joinId=?";
        List<JoinMember> result = jdbcTemplate.query(QueryFindById,new JoinMapper(),id);
        return result;
    }

    @Override
    public List<JoinMember> findMemberUseLoginInfo(LoginMember loginMember) {
        //해당 로직은 login 정보로 회원의 모든 정보를 가져옵니다.
        String QueryFindByLoginId = "select * from member where joinId=? and joinPwd=?";
        Object args[] = {loginMember.getLoginId(),loginMember.getLoginPwd()};
        List<JoinMember> result = jdbcTemplate.query(QueryFindByLoginId,new JoinMapper(),args);
        return result;
    }

    @Override
    public List<JoinMember> findDuplicateId(String duplicateId) {
        String QueryFindDuplicateId = "select joinId from member where joinId=?";
        List<JoinMember> result = jdbcTemplate.query(QueryFindDuplicateId, new JoinMapper(),duplicateId);
        return result;
    }
}