package com.ivan.threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutorService {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new MyRunnable());
        String q = executorService.submit(new MyCallable()).get();

        System.out.println(q);

        executorService.shutdown();
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("run");
    }
}

class MyCallable implements Callable<String>{
    @Override
    public String call() throws Exception {
        Thread.sleep(900);
        return "qq";
    }
} 