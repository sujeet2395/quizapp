package com.learn.quizapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.quizapplication.entity.AnswerSubmission;
import com.learn.quizapplication.entity.Quiz;
import com.learn.quizapplication.entity.User;

@Repository
public interface AnswerSubmissionRepository extends JpaRepository<AnswerSubmission, Long> {
    List<AnswerSubmission> findByUserAndQuiz(User user, Quiz quiz);

	boolean existsByUserAndQuiz(User user, Quiz quiz);
}
