package com.board.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.board.dto.BoardDto;

@Component
public class BoardMapper implements RowMapper<BoardDto>{

	@Override
	public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardDto boardDto = new BoardDto();
		boardDto.setBoardNo(rs.getInt("board_no"));
		boardDto.setUserId(rs.getString("user_id"));
		boardDto.setTitle(rs.getString("title"));
		boardDto.setContent(rs.getString("content"));
		boardDto.setCreatedAt(rs.getTimestamp("created_at"));
		boardDto.setUpdatedAt(rs.getTimestamp("updated_at"));
		return boardDto;
	}

}
