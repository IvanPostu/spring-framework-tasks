
package com.ivan.spring_context;

import com.ivan.spring_context.domain.QuestionEntity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author ivan
 */
public class ConsoleClient {
    public void performQuizAction(List<QuestionEntity> questionEntities) {
        try (Scanner in = new Scanner(System.in)) {
            int max = questionEntities.stream()
                .map(q -> q.getAnswersWeightRecords()
                    .entrySet().stream()
                    .map(e -> e.getValue()).max(Integer::compare)
                    .orElseGet(() -> 0))
                    .reduce((acc, current) -> acc + current).orElse(0);
                    
            int currentScore = 0;

            int counter = 0;
            while(counter < questionEntities.size()){
                QuestionEntity q = questionEntities.get(counter);

                StringBuilder messageBuilder = new StringBuilder(2048);
                messageBuilder.append(q.getQuestion()).append("\n");

                Set<Entry<String, Integer>> entries = q.getAnswersWeightRecords().entrySet();
                Iterator<Entry<String, Integer>> itr = entries.iterator();
                Map<Integer, Entry<String, Integer>> dict = new HashMap<>();

                int i = 0;
                while (itr.hasNext()) {
                    i++;
                    Entry<String, Integer> item = itr.next();
                    messageBuilder.append('\t').append(i).append(") ").append(item.getKey()).append("\n");
                    dict.put(i, item);
                }

                System.out.println(messageBuilder.toString());

                int index = in.nextInt();

                if(dict.containsKey(index)){
                    counter++;
                    currentScore += dict.get(index).getValue();
                }

            }

            float result = (float)currentScore / max * 100;
            System.out.println(String.format("Yout current score is %.02f -> (%d/%d)", result, max, currentScore));

        }

    }
}
