package com.ivan.spring_context;

import java.util.List;
import java.util.Optional;

import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.service.QuizService;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        QuizService quizService = context.getBean(QuizService.class);

        String csvData = ResourceReader.readFromResources("/questions.csv");
        Optional<List<QuestionEntity>> quiz = quizService.getQuiz(csvData);

        ConsoleClient client = new ConsoleClient();
        client.performQuizAction(quiz.orElseThrow());

        context.close();
    }
}
