package com.multipurpose.web.mapper.checkmapper;

import com.multipurpose.web.vo.JoinMember;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class IdDuplicatedCheckMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        JoinMember joinMember = new JoinMember();
        joinMember.setJoinId(rs.getString("joinId"));
        return joinMember;
    }
}
