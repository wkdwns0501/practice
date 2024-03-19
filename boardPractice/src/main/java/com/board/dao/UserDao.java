package com.board.dao;

import java.util.List;

import com.board.dto.UserDto;

public interface UserDao {
	
	void insert(UserDto userDto); //등록
	UserDto selectOne(String userId); //단일조회
	List<UserDto> selectList(); //전체조회
	boolean delete(String userId); //삭제
	
	//수정 임시 보류
//	boolean update(UserDto userDto); 
	
}
