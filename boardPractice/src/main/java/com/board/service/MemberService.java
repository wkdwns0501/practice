package com.board.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.board.dto.MemberDto;
import com.board.entity.Member;
import com.board.repository.MemberRepository;

@Service
public class MemberService {
	
	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public MemberService(MemberRepository memberRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.memberRepository = memberRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public void joinProcess(MemberDto memberDto) {
		
		String memberId = memberDto.getMemberId();
		String passwd = memberDto.getPasswd();
		String nickname = memberDto.getNickname();
		String email = memberDto.getEmail();
		String tel = memberDto.getEmail();
		String status = memberDto.getStatus();
		String sex = memberDto.getSex();
		String myLevel = memberDto.getMyLevel();
		
		Boolean isExist = memberRepository.existsByMemberId(memberId);
		
		if (isExist) {
			return;
		}
		
		Member data = new Member();
		data.setMemberId(memberId);
		data.setPasswd(bCryptPasswordEncoder.encode(passwd));
		data.setNickname(nickname);
		data.setEmail(email);
		data.setTel(tel);
		data.setStatus(status);
		data.setSex(sex);
		data.setMyLevel(myLevel);
		
		memberRepository.save(data);
	}
}
