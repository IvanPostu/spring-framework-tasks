package com.ivan.spring_context.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.exceptions.GeneralMapperException;
import com.ivan.spring_context.mappers.QuestionEntityMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

@ExtendWith(MockitoExtension.class)
public class QuizServiceImplTest {

    @Test
    public void testGetQuizSuccessCase(@Mock QuestionEntityMapper questionEntityMapperMock)
            throws GeneralMapperException {
        when(questionEntityMapperMock.mapToQuestionEntities(any(String.class)))
                .then(new Answer<List<QuestionEntity>>() {

                    @Override
                    public List<QuestionEntity> answer(InvocationOnMock invocation) throws Throwable {
                        var result = Arrays.asList(
                                new QuestionEntity(1, "qq", Map.ofEntries(
                                        Map.entry("q", 1))));

                        return result;
                    }
                });

        QuizServiceImpl quizServiceImpl = new QuizServiceImpl(questionEntityMapperMock);
        Optional<List<QuestionEntity>> result = quizServiceImpl.getQuiz("csv example");

        Assertions.assertEquals(1, result.orElseThrow().size());
    }

    @Test
    public void testGetQuizCaseWhenMapperThrowsException(@Mock QuestionEntityMapper questionEntityMapperMock)
            throws GeneralMapperException {
        when(questionEntityMapperMock.mapToQuestionEntities(any(String.class)))
                .then(new Answer<List<QuestionEntity>>() {

                    @Override
                    public List<QuestionEntity> answer(InvocationOnMock invocation) throws Throwable {
                        throw new GeneralMapperException(new Exception("qwe1"));
                    }

                });
        QuizServiceImpl quizServiceImpl = new QuizServiceImpl(questionEntityMapperMock);
        Optional<List<QuestionEntity>> result = quizServiceImpl.getQuiz("csv example");

        Assertions.assertTrue(result.isEmpty());
    }
}
