package com.ivan.threads;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ForkJoinApiExampleTest {

    @Test
    void testCalculateBillionInForLoop() {
        ForkJoinApiExample forkJoinApiExample = new ForkJoinApiExample();
        ForkJoinApiExample.IterativeBillionCalculator calc = new ForkJoinApiExample
            .IterativeBillionCalculator();
        long startTime, endTime, result;

        startTime = System.currentTimeMillis();
        result = forkJoinApiExample.calculateBillionInForLoop();
        endTime = System.currentTimeMillis();
        long parallelExecutionTimeInMillis = endTime - startTime;

        Assertions.assertEquals(10_000_000_000l, result);


        startTime = System.currentTimeMillis();
        result = calc.calculateBillionInForLoop();
        endTime = System.currentTimeMillis();
        long iterativeExecutionTimeInMillis = endTime - startTime;

        Assertions.assertEquals(10_000_000_000l, result);

        Assertions.assertTrue(parallelExecutionTimeInMillis < iterativeExecutionTimeInMillis);
    }

}
