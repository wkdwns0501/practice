package com.board.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.board.dto.UserDto;

@Component
public class UserMapper implements RowMapper<UserDto>{

	@Override
	public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserDto userDto = new UserDto();
		userDto.setUserId(rs.getString("user_id"));
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
