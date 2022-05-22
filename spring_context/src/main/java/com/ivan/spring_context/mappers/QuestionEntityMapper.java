package com.ivan.spring_context.mappers;

import com.ivan.spring_context.domain.QuestionEntity;
import java.util.List;

/**
 *
 * @author ivan
 */
public interface QuestionEntityMapper {
    List<QuestionEntity> mapToQuestionEntities(String data);
}
