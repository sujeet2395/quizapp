package com.learn.quizapplication.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "questions")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String text;
    
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<AnswerOption> options;
    
    @OneToOne
    private AnswerOption correctAnswer;
    
    public Question(String text, List<AnswerOption> options, int correctIndex) {
    	this.text = text;
    	this.options = options;
    	this.options.stream().peek(a -> a.setQuestion(this));
    	this.correctAnswer = options.get(correctIndex);
    }
    public Question(String text) {
    	this.text = text;
    	this.options = new ArrayList<AnswerOption>();
    }
    public Question(List<AnswerOption> options, int correctIndex) {
    	this.options = options;
    	this.options.stream().peek(a -> a.setQuestion(this));
    	this.correctAnswer = options.get(correctIndex);
    }
    
    public void setOptions(List<AnswerOption> options, int correctIndex) {
    	this.options = options;
    	this.options.stream().peek(a -> a.setQuestion(this));
    	this.correctAnswer = options.get(correctIndex);
    }
}