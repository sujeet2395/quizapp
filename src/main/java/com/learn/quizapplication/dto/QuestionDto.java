package com.learn.quizapplication.dto;

import java.util.List;

import com.learn.quizapplication.entity.AnswerOption;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuestionDto {
	private Long id;
    private String text;
    private List<AnswerOption> options;
}
