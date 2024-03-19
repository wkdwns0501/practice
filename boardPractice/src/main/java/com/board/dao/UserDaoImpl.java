package com.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.board.dto.UserDto;
import com.board.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private UserMapper userMapper;

	@Override
	public void insert(UserDto userDto) {
		String sql = "insert into user(user_id, passwd, email, nickname, tel, status, sex, my_level) "
						+ "values (?, ? ,?, ?, ?, ?, ?, ?)";
		Object[] data = {userDto.getUserId(), userDto.getPasswd(), userDto.getEmail(), userDto.getNickname(), 
								userDto.getTel(), userDto.getStatus(), userDto.getSex(), userDto.getMyLevel()};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public UserDto selectOne(String userId) {
		String sql = "select * from user where user_id = ?";
		Object[] data = {userId};
		List<UserDto> userList = jdbcTemplate.query(sql, userMapper, data);
		return userList.isEmpty() ? null : userList.get(0);
	}

	@Override
	public List<UserDto> selectList() {
		String sql = "select * from user order by user_id asc";
		return jdbcTemplate.query(sql, userMapper);
	}

	@Override
	public boolean delete(String userId) {
		String sql = "delete user where user_id = ?";
		Object[] data = {userId};
		return jdbcTemplate.update(sql, data) > 0;
	}

	//수정 임시 보류
//	@Override
//	public boolean update(UserDto userDto) {
//		String sql = "update user set nickname = ? where user_id = ?";
//		Object[] data = {userDto.getNickname(), userDto.getUserId()};
//		return jdbcTemplate.update(sql, data) > 0;
//	}

}
