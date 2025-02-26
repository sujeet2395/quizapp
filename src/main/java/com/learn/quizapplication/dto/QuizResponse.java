package com.learn.quizapplication.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizResponse {
	private Long id;
    private String title;
    private List<QuestionDto> questions;
}
