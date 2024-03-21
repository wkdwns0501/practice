package com.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.board.dto.MemberDto;
import com.board.mapper.MemberMapper;

@Repository
public class MemberDaoImpl implements MemberDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private MemberMapper memberMapper;

	@Override
	public void insert(MemberDto userDto) {
		String sql = "insert into user(member_id, passwd, email, nickname, tel, sex ) "
						+ "values (?, ? ,?, ?, ?, ?)";
		Object[] data = {userDto.getMemberId(), userDto.getPasswd(), userDto.getEmail(), userDto.getNickname(), 
								userDto.getTel(), 
//								userDto.getStatus(), 
								userDto.getSex() 
//								,userDto.getMyLevel()
								}; //sql 문에서도 제외시켰음
		jdbcTemplate.update(sql, data);
	}

	@Override
	public MemberDto selectOne(String memberId) {
		String sql = "select * from member where member_id = ?";
		Object[] data = {memberId};
		List<MemberDto> memberList = jdbcTemplate.query(sql, memberMapper, data);
		return memberList.isEmpty() ? null : memberList.get(0);
	}

	@Override
	public List<MemberDto> selectList() {
		String sql = "select * from member order by member_id asc";
		return jdbcTemplate.query(sql, memberMapper);
	}

	@Override
	public boolean delete(String memberId) {
		String sql = "delete member where member_id = ?";
		Object[] data = {memberId};
		return jdbcTemplate.update(sql, data) > 0;
	}

	//수정 임시 보류
//	@Override
//	public boolean update(MemberDto memberDto) {
//		String sql = "update member set nickname = ? where member_id = ?";
//		Object[] data = {userDto.getNickname(), userDto.getMemberId()};
//		return jdbcTemplate.update(sql, data) > 0;
//	}

}
