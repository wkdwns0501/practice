package com.board.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.board.dto.CommentDto;

@Component
public class CommentMapper implements RowMapper<CommentDto>{

	@Override
	public CommentDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		CommentDto commentDto = new CommentDto();
		commentDto.setCommentId(rs.getInt("comment_id"));
		commentDto.setBoardNo(rs.getString("board_no"));
		commentDto.setUserId(rs.getString("user_id"));
		commentDto.setContent(rs.getString("content"));
		commentDto.setCreatedAt(rs.getTimestamp("created_at"));
		return commentDto;
	}

}
