package com.learn.quizapplication.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.quizapplication.entity.User;
import com.learn.quizapplication.service.UserService;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping
    public ResponseEntity<Map<String, Object>> createUser(@RequestBody User user) {
    	Map<String, Object> response = new HashMap<>();
    	try {
    		response.put("data", userService.createUser(user));
    		response.put("status", "success");
    		return new ResponseEntity<>(response, HttpStatus.CREATED);
    	} catch (Exception e) {
    		response.put("message", e.getMessage());
    		response.put("status", "failure");
		}
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
