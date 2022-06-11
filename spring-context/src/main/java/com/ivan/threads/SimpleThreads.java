package com.ivan.threads;

public class SimpleThreads {

    public static void runCustomThread() {
        Thread t = new CustomThread();
        t.start();

        Thread t1 = new Thread(new MyRunnable001());
        t1.start();
    }

}

class CustomThread extends Thread {
    @Override
    public void run() {
        throw new RuntimeException("123");
    }
}

class MyRunnable001 implements Runnable {
    @Override
    public void run() {
        System.out.println(1);
    }
}