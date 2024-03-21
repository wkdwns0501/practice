package com.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String>{
	
	Boolean existsByMemberId(String memberId);
}
