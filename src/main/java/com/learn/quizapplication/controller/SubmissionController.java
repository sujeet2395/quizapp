package com.learn.quizapplication.controller;

import java.util.HashMap;
import java.util.List;
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

import com.learn.quizapplication.dto.AnswerSubmissionRequest;
import com.learn.quizapplication.service.SubmissionService;

@RestController
@RequestMapping("/api/v1/submissions")
public class SubmissionController {
    
    @Autowired
    private SubmissionService submissionService;
    
    @PostMapping("/user/{userId}/quiz/{quizId}/submit")
    public ResponseEntity<Map<String, Object>> submitAnswers(@PathVariable Long userId, @PathVariable Long quizId, 
                                                @RequestBody List<AnswerSubmissionRequest> answers) {
        Map<String, Object> response = new HashMap<>();
    	try {
    		submissionService.submitAnswers(userId, quizId, answers);
    		response.put("data", "Answers submitted successfully!");
    		response.put("status", "success");
    		return new ResponseEntity<>(response, HttpStatus.CREATED);
    	} catch (Exception e) {
    		response.put("message", e.getMessage());
    		response.put("status", "failure");
		}
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/user/{userId}/quiz/{quizId}/result")
    public ResponseEntity<Map<String, Object>> getResult(@PathVariable Long userId, @PathVariable Long quizId) {
    	Map<String, Object> response = new HashMap<>();
    	try {
    		response.put("data", submissionService.calculateResult(userId, quizId));
    		response.put("status", "success");
    		return new ResponseEntity<>(response, HttpStatus.CREATED);
    	} catch (Exception e) {
    		response.put("message", e.getMessage());
    		response.put("status", "failure");
		}
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
