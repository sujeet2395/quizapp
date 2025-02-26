package com.learn.quizapplication.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.learn.quizapplication.entity.AnswerOption;
import com.learn.quizapplication.entity.Question;
import com.learn.quizapplication.repository.AnswerOptionRepository;
import com.learn.quizapplication.repository.QuestionRepository;

@Component
public class QuestionSeeder implements CommandLineRunner {

    @Autowired
    private QuestionRepository questionRepository;
    
    @Autowired
    private AnswerOptionRepository answerOptionRepository;

    @Override
    public void run(String... args) throws Exception {
        if (questionRepository.count() == 0) {
			List<Question> questions = new ArrayList<>();
			int count = 0;
			questions.add(new Question("What is the capital of France?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("Berlin", questions.get(count)),
					new AnswerOption("Madrid", questions.get(count)), new AnswerOption("Paris", questions.get(count)),
					new AnswerOption("Rome", questions.get(count))), 2);
			count++;
			
			questions.add(new Question("What is the chemical symbol for water?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("H₂O", questions.get(count)),
							new AnswerOption("CO₂", questions.get(count)), new AnswerOption("O₂", questions.get(count)),
							new AnswerOption("NaCl", questions.get(count))), 1);
			count++;
			
			questions.add(new Question("What is the square root of 64?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("6", questions.get(count)),
							new AnswerOption("7", questions.get(count)), new AnswerOption("8", questions.get(count)),
							new AnswerOption("9", questions.get(count))), 2);
			count++;

			questions.add(new Question("Which programming language is used for Android development?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("Swift", questions.get(count)),
					new AnswerOption("Python", questions.get(count)), new AnswerOption("C++", questions.get(count)),
					new AnswerOption("Java", questions.get(count))), 3);
			count++;

			questions.add(new Question("Who was the first President of the United States?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("Thomas Jefferson", questions.get(count)),
							new AnswerOption("Abraham Lincoln", questions.get(count)),
							new AnswerOption("George Washington", questions.get(count)),
							new AnswerOption("Benjamin Franklin", questions.get(count))), 2);
			count++;

			questions.add(new Question("How many players are there in a standard soccer team (on the field)?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("9", questions.get(count)),
							new AnswerOption("10", questions.get(count)), new AnswerOption("12", questions.get(count)),
							new AnswerOption("11", questions.get(count))), 3);
			count++;

			questions.add(new Question("Which is the largest continent in the world?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("Africa", questions.get(count)),
					new AnswerOption("Asia", questions.get(count)), new AnswerOption("Europe", questions.get(count)),
					new AnswerOption("North America", questions.get(count))), 1);
			count++;

			questions.add(new Question("Which planet is known as the Red Planet?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("Earth", questions.get(count)),
					new AnswerOption("Mars", questions.get(count)), new AnswerOption("Jupiter", questions.get(count)),
					new AnswerOption("Venus", questions.get(count))), 1);
			count++;

			questions.add(new Question("What does 'HTML' stand for?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("HyperText Markup Language", questions.get(count)),
							new AnswerOption("HighText Machine Learning", questions.get(count)),
							new AnswerOption("HyperTransfer Markup Language", questions.get(count)),
							new AnswerOption("HyperTech Marking Language", questions.get(count))), 0);
			count++;

			questions.add(new Question("Which movie features the quote, 'I'll be back'?"));
			questions.get(count).setOptions(Arrays.asList(new AnswerOption("The Terminator", questions.get(count)),
							new AnswerOption("Die Hard", questions.get(count)),
							new AnswerOption("The Matrix", questions.get(count)),
							new AnswerOption("Inception", questions.get(count))), 0);
			count++;
            List<Question> savedQuestions = questionRepository.saveAll(questions);
            savedQuestions.stream().forEach(q -> {
				q.getOptions().stream().peek(a -> a.setQuestion(q));
				answerOptionRepository.saveAll(q.getOptions());
			});
            System.out.println("Seeded initial questions into the database!");
        }
    }
}
