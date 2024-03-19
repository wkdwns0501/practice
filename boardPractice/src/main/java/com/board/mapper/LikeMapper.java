package com.board.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.board.dto.LikeDto;

@Component
public class LikeMapper implements RowMapper<LikeDto>{

	@Override
	public LikeDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		LikeDto likeDto = new LikeDto();
		likeDto.setLikeNo(rs.getInt("like_no"));
		likeDto.setBoardNo(rs.getInt("board_no"));
		likeDto.setUserId(rs.getString("user_id"));
		likeDto.setCreatedAt(rs.getTimestamp("created_at"));
		return likeDto;
	}

}
