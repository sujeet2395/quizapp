package com.learn.quizapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.quizapplication.entity.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
