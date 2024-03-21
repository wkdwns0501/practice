package com.board.dto;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class LikeDto {
	private int likeNo;
	private int boardNo;
	private String memberId;
	private Timestamp createdAt;
}
