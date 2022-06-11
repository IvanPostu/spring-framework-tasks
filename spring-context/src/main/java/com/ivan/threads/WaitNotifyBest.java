package com.ivan.threads;

public class WaitNotifyBest {

    public static void main(String[] args) throws InterruptedException {
        
        Object sync = new Object();

        new Thread(() -> {

            synchronized(sync){
                String threadName = Thread.currentThread().getName();
                System.out.println(String.format("Thread %s is waiting of unlock!", threadName));

                try {
                    sync.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(String.format("Thread %s have been unlocked!", threadName));
            }

        }).start();

        Thread.sleep(2000);

        new Thread(() -> {

            synchronized(sync){

                sync.notify();
            }

        }).start();

    }

}
