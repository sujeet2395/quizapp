package com.learn.quizapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizRequest {
	private String title;
	private Long userId;
	private int questionCount;
}
