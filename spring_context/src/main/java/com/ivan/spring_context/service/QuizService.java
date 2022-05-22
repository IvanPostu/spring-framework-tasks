package com.ivan.spring_context.service;

import java.util.List;
import java.util.Optional;

import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.domain.QuizResult;

/**
 *
 * @author ivan
 */
public interface QuizService {

    public Optional<List<QuestionEntity>> getQuiz(String data);

    public QuizResult performQuiz(List<QuestionEntity> questionEntities);

}
