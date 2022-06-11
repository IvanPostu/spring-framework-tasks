package com.ivan.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class UseCallable {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = new CustomCallable();
        FutureTask<Integer> futureTask = new FutureTask<>(callable);

        new Thread(futureTask).start();

        System.out.println(futureTask.get());
    }

}

class CustomCallable implements Callable<Integer>{
    @Override
    public Integer call() throws Exception {
        int i= 99;

        Thread.sleep(2000);

        return i;
    }
}