package com.multipurpose.web.mapper.basicmapper;

import com.multipurpose.web.vo.LoginMember;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

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
