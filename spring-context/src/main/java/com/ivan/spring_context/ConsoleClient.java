
package com.ivan.spring_context;

import java.util.List;
import java.util.Optional;

import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.domain.QuizResult;
import com.ivan.spring_context.service.QuizService;

/**
 *
 * @author ivan
 */
public class ConsoleClient {
    
    public static void run(QuizService quizService, String csvData){
        Optional<List<QuestionEntity>> questionEntities = quizService.getQuiz(csvData);
        QuizResult quizResult = quizService.performQuiz(questionEntities.orElseThrow());
        quizResult.printFormattedResult();
    }

}
