package com.board.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.board.dto.MemberDto;

@Component
public class MemberMapper implements RowMapper<MemberDto>{

	@Override
	public MemberDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberDto userDto = new MemberDto();
		userDto.setMemberId(rs.getString("member_id"));
		userDto.setPasswd(rs.getString("passwd"));
		userDto.setNickname(rs.getString("nickname"));
		userDto.setEmail(rs.getString("email"));
		userDto.setTel(rs.getString("tel"));
		userDto.setStatus(rs.getString("status"));
		userDto.setSex(rs.getString("sex"));
		userDto.setMyLevel(rs.getString("my_level"));
		return userDto;
	}

}
