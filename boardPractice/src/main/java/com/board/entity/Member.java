package com.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
public class Member{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private String memberId;
	 private String passwd;
	 private String nickname;
	 private String email;
	 private String tel;
	 private String status;
	 private String sex;
	 private String myLevel;
}
