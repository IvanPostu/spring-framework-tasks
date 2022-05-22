package com.ivan.spring_context.mappers;

import com.ivan.spring_context.domain.QuestionEntity;
import com.ivan.spring_context.exceptions.GeneralMapperException;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ivan
 */
public class QuestionEntityCSVMapper implements QuestionEntityMapper {

    @Setter
    private char fieldTerminator;

    @Override
    public List<QuestionEntity> mapToQuestionEntities(String data) throws GeneralMapperException {
        List<QuestionEntity> result = null;

        try {
            String[] lines = data.split("\n");
            result = new ArrayList<>(lines.length);

            if (lines.length <= 1) {
                throw new IllegalArgumentException(
                        "CSV file must have first line with column definitions and at least one row with records!");
            }

            for (int i = 1; i < lines.length; i++) {
                String[] items = lines[i].split(String.valueOf(fieldTerminator));

                for (String item : items) {
                    item = removeStartAndEndSemiColonIfExists(item);
                }

                Map<String, Integer> answersWithWeights = new HashMap<>();

                String[] weights = removeStartAndEndSemiColonIfExists(items[3]).split(";");
                String[] answers = removeStartAndEndSemiColonIfExists(items[2]).split(";");

                if (answers.length != weights.length) {
                    throw new GeneralMapperException(
                            "Answers count isn't equal to weights count");
                }

                for (int j = 0; j < answers.length; j++) {
                    answersWithWeights.put(answers[j], Integer.parseInt(weights[j]));
                }

                QuestionEntity e = new QuestionEntity(
                        Integer.parseInt(items[0]),
                        removeStartAndEndSemiColonIfExists(items[1]),
                        answersWithWeights);
                result.add(e);
            }

        } catch (Exception e) {
            throw new GeneralMapperException(e);
        }

        return result;
    }

    private String removeStartAndEndSemiColonIfExists(String item) {
        if (item.startsWith("\"") && item.endsWith("\"")) {
            return item.substring(1, item.length() - 1);
        }

        return item;
    }

}
