package com.learn.quizapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.quizapplication.dto.QuizRequest;
import com.learn.quizapplication.service.QuizService;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {
    
    @Autowired
    private QuizService quizService;

    @PostMapping
    public ResponseEntity<Map<String, Object>> createQuiz(@RequestBody QuizRequest quizRequest) {
    	Map<String, Object> response = new HashMap<>();
    	try {
    		response.put("data", quizService.createQuiz(quizRequest));
    		response.put("status", "success");
    		return new ResponseEntity<>(response, HttpStatus.CREATED);
    	} catch (Exception e) {
    		response.put("message", e.getMessage());
    		response.put("status", "failure");
		}
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/{quizId}")
    public ResponseEntity<Map<String, Object>> getQuiz(@PathVariable Long quizId) {
    	Map<String, Object> response = new HashMap<>();
    	try {
    		response.put("data", quizService.getQuiz(quizId));
    		response.put("status", "success");
    		return new ResponseEntity<>(response, HttpStatus.OK);
    	} catch (Exception e) {
    		response.put("message", e.getMessage());
    		response.put("status", "failure");
		}
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllQuiz() {
    	Map<String, Object> response = new HashMap<>();
    	try {
    		response.put("data", quizService.getAllQuiz());
    		response.put("status", "success");
    		return new ResponseEntity<>(response, HttpStatus.OK);
    	} catch (Exception e) {
    		response.put("message", e.getMessage());
    		response.put("status", "failure");
		}
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
