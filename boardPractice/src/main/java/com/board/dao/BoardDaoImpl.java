package com.board.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.board.dto.BoardDto;
import com.board.mapper.BoardMapper;

@Repository
public class BoardDaoImpl implements BoardDao{

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Override
	public int boardSeq() {
		String sql = "select board_seq.nextval from dual";
		return jdbcTemplate.queryForObject(sql, int.class);
	}

	@Override
	public void insert(BoardDto boardDto) {
		String sql = "insert into board(board_no, member_id, title, content, created_at, updated_at) "
						+ "values (?, ?, ?, ?, ?, ?)";
		Object[] data = {boardDto.getBoardNo(), boardDto.getMemberId(), 
								boardDto.getTitle(), boardDto.getContent(), 
								boardDto.getCreatedAt(), boardDto.getUpdatedAt()};
		jdbcTemplate.update(sql, data);
	}

	@Override
	public List<BoardDto> selectList() {
		String sql = "select * from board order by board_no desc";
		return jdbcTemplate.query(sql,  boardMapper);
	}

	@Override
	public BoardDto selectOne(int boardNo) {
		String sql = "select * from board where board_no = ?";
		Object[] data = {boardNo};
		List<BoardDto> boardList = jdbcTemplate.query(sql,  boardMapper, data);
		return boardList.isEmpty() ? null : boardList.get(0);
	}

	@Override
	public boolean delete(int boardNo) {
		String sql = "delete board where board_no = ?";
		Object[] data = {boardNo};
		return jdbcTemplate.update(sql, data) > 0;
	}

	//수정 임시 보류
//	@Override
//	public boolean update(BoardDto boardDto) {
//		String sql = "update board set title = ?, content = ? where board_no = ?";
//		Object[] data = {boardDto.getTitle(), boardDto.getContent(), boardDto.getBoardNo()};
//		return jdbcTemplate.update(sql, data) > 0;
//	}

}
