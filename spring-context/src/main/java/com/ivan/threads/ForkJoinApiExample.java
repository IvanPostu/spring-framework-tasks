package com.ivan.threads;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinApiExample implements BillionCalculator {

    private static int numOfThreads = Runtime.getRuntime().availableProcessors();
    private static long numOfOperations = 10_000_000_000L;

    public static class MyRecursiveTask extends RecursiveTask<Long> {

        long from, to;

        public MyRecursiveTask(long from, long to) {
            this.from = from;
            this.to = to;
        }

        @Override
        protected Long compute() {
            if((to - from) < numOfOperations / numOfThreads){
                long j=0;
                for(long i=from; i<to; i++){
                    j+=1;
                }
                return j;
            }else{
                long middle = (to + from) / 2;
                MyRecursiveTask firstHalf = new MyRecursiveTask(from, middle);
                firstHalf.fork();
                MyRecursiveTask secondHalf = new MyRecursiveTask(middle, to);
                long secondValue = secondHalf.compute();
                
                return firstHalf.join() + secondValue;
            }
        }

    }

    @Override
    public long calculateBillionInForLoop() {
        ForkJoinPool pool = new ForkJoinPool(numOfThreads);
        long result = pool.invoke(new MyRecursiveTask(0, numOfOperations));
        return result;
    }

    public static class IterativeBillionCalculator implements BillionCalculator {

        @Override
        public long calculateBillionInForLoop() {
            long res = 0;

            for (long i = 0; i < numOfOperations; i++) {
                res += 1;
            }

            return res;
        }
        
    }
}
