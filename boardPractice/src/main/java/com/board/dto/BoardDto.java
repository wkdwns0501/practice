package com.board.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class BoardDto {
	private int boardNo;
	private String memberId;
	private String title;
	private String content;
	private Timestamp createdAt;
	private Timestamp updatedAt;
}
