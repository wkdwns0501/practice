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
		commentDto.setCommentNo(rs.getInt("comment_no"));
		commentDto.setBoardNo(rs.getString("board_no"));
		commentDto.setMemberId(rs.getString("member_id"));
		commentDto.setContent(rs.getString("content"));
		commentDto.setCreatedAt(rs.getTimestamp("created_at"));
		return commentDto;
	}

}
