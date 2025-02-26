package com.learn.quizapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "submissions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerSubmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;
    
    @ManyToOne
    private Quiz quiz;
    
    @ManyToOne
    private Question question;
    
    @ManyToOne
    private AnswerOption selectedAnswer;

	public AnswerSubmission(User user, Quiz quiz, Question question, AnswerOption selectedAnswer) {
		super();
		this.user = user;
		this.quiz = quiz;
		this.question = question;
		this.selectedAnswer = selectedAnswer;
	}
}
