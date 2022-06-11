package com.ivan.threads;

public class WaitNotify2 {
    
    public static void main(String[] args) throws InterruptedException {
        ThreadA t = new ThreadA();
        t.start();

        synchronized(t){
            t.wait();
        }

        System.out.println(t.total);
    }

    static class ThreadA extends Thread {
        int total;

        @Override
        public void run() {
            synchronized(this){
                for (int i = 0; i < 5; i++) {
                    total+=i;
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("notify");
                notify();
            }
        }
    }

}
