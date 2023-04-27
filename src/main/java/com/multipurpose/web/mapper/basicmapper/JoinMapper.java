package com.multipurpose.web.mapper.basicmapper;


import com.multipurpose.web.vo.JoinMember;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JoinMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        JoinMember joinMember = new JoinMember();
        joinMember.setJoinName(rs.getString("joinName"));
        joinMember.setJoinId(rs.getString("joinId"));
        joinMember.setJoinPwd(rs.getString("joinPwd"));
        joinMember.setJoinCall(rs.getString("joinCall"));
        return joinMember;
    }
}
