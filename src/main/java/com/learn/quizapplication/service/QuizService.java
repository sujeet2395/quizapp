package com.learn.quizapplication.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.quizapplication.dto.QuestionDto;
import com.learn.quizapplication.dto.QuizRequest;
import com.learn.quizapplication.dto.QuizResponse;
import com.learn.quizapplication.entity.Question;
import com.learn.quizapplication.entity.Quiz;
import com.learn.quizapplication.repository.QuestionRepository;
import com.learn.quizapplication.repository.QuizRepository;

@Service
public class QuizService {

	@Autowired
    private QuizRepository quizRepository;

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public QuizResponse createQuiz(QuizRequest quizRequest) {
        Quiz quiz = new Quiz();
        quiz.setTitle(quizRequest.getTitle());
        
        List<Question> randomQuestions = questionRepository.findRandomQuestions(quizRequest.getQuestionCount());
        quiz.setQuestions(randomQuestions);
        
        return mapQuizToQuizResponse(quizRepository.save(quiz));
    }

    private QuizResponse mapQuizToQuizResponse(Quiz quiz) {
    	List<QuestionDto> questionDtos = this.mapQuestionsToQuestionDto(quiz.getQuestions());    	
    	QuizResponse quizResponse = modelMapper.map(quiz, QuizResponse.class);
    	quizResponse.setQuestions(questionDtos);
    	return quizResponse;
    }
    
    private List<QuestionDto> mapQuestionsToQuestionDto(List<Question> questions) {
		return questions.stream().map(q -> modelMapper.map(q, QuestionDto.class)).toList();
	}

	public QuizResponse getQuiz(Long quizId) {
        return this.mapQuizToQuizResponse(quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("Quiz not found.")));
    }

	public List<QuizResponse> getAllQuiz() {
		return quizRepository.findAll().stream().map(qz -> this.mapQuizToQuizResponse(qz)).toList();
	}
}
