package com.board.dao;

import java.util.List;

import com.board.dto.LikeDto;

public interface LikeDao {
	
	int likeSeq(); //시퀀스
	void insert(LikeDto likeDto); //등록
	List<LikeDto> selectList(String memberId); //리스트조회
	boolean delete(int likeNo); //삭제
}
