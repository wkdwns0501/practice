package com.board.dto;

import lombok.Data;

@Data
public class MemberDto {
	private String memberId;
	private String passwd;
	private String nickname;
	private String email;
	private String tel;
	private String status;
	private String sex;
	private String myLevel;
}
