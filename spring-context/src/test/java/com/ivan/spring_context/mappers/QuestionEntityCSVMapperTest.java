package com.ivan.spring_context.mappers;

import java.util.List;
import java.util.Map;

import com.ivan.spring_context.ResourceReader;
import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.exceptions.GeneralMapperException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class QuestionEntityCSVMapperTest {

    @Test
    public void testMapToQuestionEntitiesSuccessCase() throws GeneralMapperException {
        String csvData = ResourceReader.readFromResources("/testQuestions.valid.csv");
        QuestionEntityCSVMapper csvMapper = new QuestionEntityCSVMapper();
        csvMapper.setFieldTerminator(',');

        List<QuestionEntity> mappedData = csvMapper.mapToQuestionEntities(csvData);

        int mappedDataItemsCount = mappedData.size();

        Assertions.assertEquals(1, mappedDataItemsCount);

        QuestionEntity questionItem = mappedData.get(0);

        Assertions.assertEquals("How old are you?", questionItem.getQuestion());
        Assertions.assertEquals(1, questionItem.getId());

        Map<String, Integer> expectedAnswerData = Map.ofEntries(
            Map.entry(" < 18", 2),
            Map.entry(" > 18 && < 24", 4),
            Map.entry(" > 24", 9)
        );

        questionItem.getAnswersWeightRecords().entrySet().forEach(answer -> {
            Assertions.assertEquals(expectedAnswerData.get(answer.getKey()), answer.getValue());
        });
    }

    @Test
    public void testMapToQuestionEntitiesErrorCase() throws GeneralMapperException {
        String csvData = ResourceReader.readFromResources("/testQuestions.invalid.csv");
        QuestionEntityCSVMapper csvMapper = new QuestionEntityCSVMapper();
        Assertions.assertThrows(GeneralMapperException.class, () -> {
            csvMapper.mapToQuestionEntities(csvData);
        });
    }
}
