package com.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.board.dto.LikeDto;
import com.board.mapper.LikeMapper;

@Repository
public class LikeDaoImpl implements LikeDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private LikeMapper likeMapper;
	
	@Override
	public int likeSeq() {
		String sql = "select like_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public void insert(LikeDto likeDto) {
		String sql = "insert into like(like_no, board_no, user_id) values (?, ?, ?)";
		Object[] data = {likeDto.getLikeNo(), likeDto.getBoardNo(), likeDto.getUserId()};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public List<LikeDto> selectList(String userId) {
		String sql = "select * from like where userId = ?";
		Object[] data = {userId};
		return jdbcTemplate.query(sql, likeMapper, data);
	}

	@Override
	public boolean delete(int likeNo) {
		String sql = "delete like where like_no = ?";
		Object[] data = {likeNo};
		return jdbcTemplate.update(sql, data) > 0;
	}

}
