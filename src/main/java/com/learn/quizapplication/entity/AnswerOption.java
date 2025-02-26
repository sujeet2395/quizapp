package com.learn.quizapplication.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "answer_options")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AnswerOption {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String answerOption;
	@ManyToOne
	@JsonIgnore
    private Question question;
	public AnswerOption(String answerOption) {
		this.answerOption = answerOption;
	}
	public AnswerOption(String answerOption, Question question) {
		this.answerOption = answerOption;
		this.question = question;
	}
}
