package com.board.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class CommentDto {
	private int commentNo;
	private String boardNo;
	private String memberId;
	private String content;
	private Timestamp createdAt;
}
