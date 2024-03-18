package com.board.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class LikeDto {
	private int likeNo;
	private int boardNo;
	private String userId;
	private LocalDateTime createdAt;
}
