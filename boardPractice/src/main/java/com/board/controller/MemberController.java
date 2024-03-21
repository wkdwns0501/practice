package com.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.board.dto.MemberDto;
import com.board.service.MemberService;

@Controller
@ResponseBody
public class MemberController {
	
	private final MemberService memberService;
	
	public MemberController(MemberService memberService) {
		
		this.memberService = memberService;
	}
	
	@PostMapping("/join")
	public String joinProcess(MemberDto memberDto) {
		memberService.joinProcess(memberDto);
		return "Join Success!";
	}
}
