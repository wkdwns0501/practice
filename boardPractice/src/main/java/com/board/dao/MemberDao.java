package com.board.dao;

import java.util.List;

import com.board.dto.MemberDto;

public interface MemberDao {
	
	void insert(MemberDto memberDto); //등록
	MemberDto selectOne(String memberId); //단일조회
	List<MemberDto> selectList(); //전체조회
	boolean delete(String memberId); //삭제
	
	//수정 임시 보류
//	boolean update(MemberDto memberDto); 
	
}
