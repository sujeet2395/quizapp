package com.learn.quizapplication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.quizapplication.entity.User;
import com.learn.quizapplication.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	public User createUser(User user) {
		return userRepository.save(user);
	}
}
