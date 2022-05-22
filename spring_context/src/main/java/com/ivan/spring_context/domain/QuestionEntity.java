package com.ivan.spring_context.domain;

import java.util.Map;

/**
 *
 * @author ivan
 */
public class QuestionEntity {
    private int id;
    private String question;
    private Map<String, Integer> answersWeightRecords;

    public QuestionEntity(int id, String question, Map<String, Integer> answersWeightRecords) {
        this.id = id;
        this.question = question;
        this.answersWeightRecords = answersWeightRecords;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Map<String, Integer> getAnswersWeightRecords() {
        return answersWeightRecords;
    }

    public void setAnswersWeightRecords(Map<String, Integer> answersWeightRecords) {
        this.answersWeightRecords = answersWeightRecords;
    }

    
}
