package com.ivan.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        ExecutorService e = Executors.newCachedThreadPool();
        Phaser ph = new Phaser(1);

        e.execute(new LongRunningAction(ph));
        e.execute(new LongRunningAction(ph));
        e.execute(new LongRunningAction(ph));
        ph.arriveAndAwaitAdvance();

        e.execute(new LongRunningAction(ph));
        e.execute(new LongRunningAction(ph));
        ph.arriveAndAwaitAdvance();

        e.execute(new LongRunningAction(ph));
        ph.arriveAndAwaitAdvance();

        e.shutdown();
    }
}

class LongRunningAction implements Runnable {

    private Phaser ph;

    public LongRunningAction(Phaser ph) {
        this.ph = ph;
        ph.register();
    }

    @Override
    public void run() {
        try {
            ph.arriveAndAwaitAdvance();
            System.out.println(
                    String.format("Thread: %s, phase: %d",
                            Thread.currentThread().getName(),
                            ph.getPhase()));
            Thread.sleep(20);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            ph.arriveAndDeregister();
        }
    }

}