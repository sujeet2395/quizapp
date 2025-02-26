package com.learn.quizapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerSubmissionRequest {
    private Long questionId;
    private Long selectedAnswer;
}
