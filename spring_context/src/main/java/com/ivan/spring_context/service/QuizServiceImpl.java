package com.ivan.spring_context.service;

import java.util.List;
import java.util.Optional;

import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.mappers.QuestionEntityMapper;

/**
 *
 * @author ivan
 */
public class QuizServiceImpl implements QuizService {
    
    private QuestionEntityMapper questionEntityMapper;

    public QuizServiceImpl(QuestionEntityMapper questionEntityMapper){
        this.questionEntityMapper = questionEntityMapper;
    }
    
    @Override
    public Optional<List<QuestionEntity>> getQuiz(String data) {
        try{
            List<QuestionEntity> result = questionEntityMapper.mapToQuestionEntities(data);
            return Optional.ofNullable(result);
        }catch(Exception e ){
            e.printStackTrace();
        }
        
        return Optional.empty();
    }

        
}
