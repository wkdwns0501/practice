package com.board.dao;

import java.util.List;

import com.board.dto.CommentDto;

public interface CommentDao {

	int commentSeq(); //시퀀스
	void insert(CommentDto commentDto); //등록
	List<CommentDto> selectList(int boardNo); //리스트조회
	CommentDto selectOne(int commentNo); //단일조회
	boolean delete(int commentNo); //삭제
	
	//수정 임시 보류
}
