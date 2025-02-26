package com.learn.quizapplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.quizapplication.dto.AnswerSubmissionRequest;
import com.learn.quizapplication.entity.AnswerSubmission;
import com.learn.quizapplication.entity.Question;
import com.learn.quizapplication.entity.Quiz;
import com.learn.quizapplication.entity.User;
import com.learn.quizapplication.repository.AnswerOptionRepository;
import com.learn.quizapplication.repository.AnswerSubmissionRepository;
import com.learn.quizapplication.repository.QuestionRepository;
import com.learn.quizapplication.repository.QuizRepository;
import com.learn.quizapplication.repository.UserRepository;

@Service
public class SubmissionService {
	@Autowired
    private UserRepository userRepository;
    
    @Autowired
    private QuizRepository quizRepository;
    
    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private AnswerOptionRepository answerOptionRepository;
    
    @Autowired
    private AnswerSubmissionRepository submissionRepository;
    
    public void submitAnswers(Long userId, Long quizId, List<AnswerSubmissionRequest> answers) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Quiz quiz = quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found"));

        for (AnswerSubmissionRequest answerRequest : answers) {
            Question question = questionRepository.findById(answerRequest.getQuestionId())
                    .orElseThrow(() -> new RuntimeException("Question not found"));

            AnswerSubmission submission = new AnswerSubmission(user, quiz, question, answerOptionRepository.findById(answerRequest.getSelectedAnswer()).orElseThrow(() -> new RuntimeException("Answer Option not found")));
            submissionRepository.save(submission);
        }
    }

    public int calculateResult(Long userId, Long quizId) {
        List<AnswerSubmission> submissions = submissionRepository.findByUserAndQuiz(new User(userId), new Quiz(quizId));
        
        int correctCount = 0;
        for (AnswerSubmission submission : submissions) {
            if (submission.getQuestion().getCorrectAnswer().getId().equals(submission.getSelectedAnswer().getId())) {
                correctCount++;
            }
        }
        return correctCount;
    }
}
