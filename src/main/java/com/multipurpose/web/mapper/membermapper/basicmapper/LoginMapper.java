package com.multipurpose.web.mapper.membermapper.basicmapper;

import com.multipurpose.web.vo.membervo.LoginMember;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        LoginMember loginMember = new LoginMember();
        loginMember.setLoginId(rs.getString("joinId"));
        loginMember.setLoginPwd(rs.getString("joinPwd"));
        return loginMember;
    }
}
