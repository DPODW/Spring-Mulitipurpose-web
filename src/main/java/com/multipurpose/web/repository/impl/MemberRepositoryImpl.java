package com.multipurpose.web.repository.impl;


import com.multipurpose.web.mapper.basicmapper.LoginMapper;
import com.multipurpose.web.repository.MemberRepository;
import com.multipurpose.web.vo.JoinMember;
import com.multipurpose.web.vo.LoginMember;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Slf4j
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public JoinMember insert(JoinMember joinMember) {
        String queryJoin = "insert into member(joinName,joinId,joinPwd,joinCall)values(?,?,?,?)";
        Object[] args = {joinMember.getJoinName(),joinMember.getJoinId(),joinMember.getJoinPwd(),joinMember.getJoinCall()};
        jdbcTemplate.update(queryJoin,args);
        return joinMember;
    }

    @Override
    public JoinMember update(JoinMember updateMember) {
        String queryUpdate = "update member set joinName=? , joinPwd=? , joinCall=? where joinid=?";
        Object[] args = {updateMember.getJoinName(),updateMember.getJoinPwd(),updateMember.getJoinCall(),updateMember.getJoinId()};
        jdbcTemplate.update(queryUpdate,args);
        return updateMember;
    }

    @Override
    public void delete(JoinMember deleteMember) {
        String QueryDelete = "delete from member where joinid=?";
        jdbcTemplate.update(QueryDelete,deleteMember.getJoinId());
    }

    @Override
    public List<LoginMember> logins(LoginMember loginMember) {
        String QueryLogin = "select * from member where joinId=? and joinPwd=?";
        Object args[] = {loginMember.getLoginId(),loginMember.getLoginPwd()};
        List<LoginMember> result = jdbcTemplate.query(QueryLogin,new LoginMapper(),args);
        return result;
    }




}
