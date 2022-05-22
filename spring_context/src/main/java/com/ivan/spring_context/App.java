package com.ivan.spring_context;

import com.ivan.spring_context.service.QuizService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        QuizService quizService = context.getBean(QuizService.class);
        String csvData = ResourceReader.readFromResources("/questions.csv");
        ConsoleClient.run(quizService, csvData);
        context.close();
    }
}
