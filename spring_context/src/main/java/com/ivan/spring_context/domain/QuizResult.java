package com.ivan.spring_context.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class QuizResult {

    @Getter
    @Setter
    private float resultPercentage;

    @Getter
    @Setter
    private int currentScore;

    @Getter
    @Setter
    private int maxScore;

    public void printFormattedResult() {
        System.out.println(String.format("Yout current score is %.02f -> (%d/%d)",
                resultPercentage, maxScore, currentScore));
    }

}
