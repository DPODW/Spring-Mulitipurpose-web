package com.multipurpose.web.mapper;

import com.multipurpose.web.vo.JoinMember;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CallDuplicatedCheckMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        JoinMember joinMember = new JoinMember();
        joinMember.setJoinCall(rs.getString("joinCall"));
        return joinMember;
    }

}
