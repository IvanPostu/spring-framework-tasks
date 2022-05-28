package com.ivan.spring_context.mappers;

import java.util.List;

import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.exceptions.GeneralMapperException;

public class QuestionEntityDummyMapper implements QuestionEntityMapper {

    @Override
    public List<QuestionEntity> mapToQuestionEntities(String data) throws GeneralMapperException {
        return null;
    }

    
}
