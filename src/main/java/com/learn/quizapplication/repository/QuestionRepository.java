package com.learn.quizapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.learn.quizapplication.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    
    @Query(value = "SELECT * FROM questions ORDER BY random() LIMIT :limit", nativeQuery = true)
    List<Question> findRandomQuestionsNative(@Param("limit") int limit);
    
    @Query("SELECT q FROM Question q ORDER BY FUNCTION('random') LIMIT :limit") 
    List<Question> findRandomQuestions(@Param("limit") int limit);
}
