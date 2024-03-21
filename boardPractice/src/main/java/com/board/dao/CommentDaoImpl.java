package com.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.board.dto.CommentDto;
import com.board.mapper.CommentMapper;

@Repository
public class CommentDaoImpl implements CommentDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public int commentSeq() {
		String sql = "select comment_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public void insert(CommentDto commentDto) {
		String sql = "insert into comment(comment_no, board_no, member_id, content, created_at) values(?, ?, ?, ?, ?)";
		Object[] data = {commentDto.getCommentNo(), commentDto.getBoardNo(), commentDto.getMemberId(), commentDto.getContent()};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public List<CommentDto> selectList(int boardNo) {
		String sql = "select * from comment where board_no = ? order by board_no desc";
		Object[] data = {boardNo};
		return jdbcTemplate.query(sql, commentMapper, data);
	}

	@Override
	public CommentDto selectOne(int commentNo) {
		String sql = "select * from comment where comment_no = ?";
		Object[] data = {commentNo};
		List<CommentDto> commentList = jdbcTemplate.query(sql, commentMapper, data);
		return commentList.isEmpty() ? null : commentList.get(0);
	}

	@Override
	public boolean delete(int commentNo) {
		String sql = "delete comment where comment_no = ?";
		Object[] data = {commentNo};
		return jdbcTemplate.update(sql, data) > 0;
	}

}
