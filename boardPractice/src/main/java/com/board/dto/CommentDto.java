package com.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class CommentDto {
	private int commentId;
	private String boardNo;
	private String userId;
	private String content;
	private LocalDateTime createdAt;
}
