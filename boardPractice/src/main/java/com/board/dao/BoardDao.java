package com.board.dao;

import java.util.List;

import com.board.dto.BoardDto;

public interface BoardDao {
	
	int boardSeq(); //시퀀스
	void insert(BoardDto boardDto); //등록
	List<BoardDto> selectList(); //전체조회
	BoardDto selectOne(int boardNo); //단일조회
	boolean delete(int boardNo); //삭제
	
	//수정 임시 보류
//	boolean update(BoardDto boardDto);
	
}
