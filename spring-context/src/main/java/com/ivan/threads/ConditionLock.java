package com.ivan.threads;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Stream;

public class ConditionLock {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();
    static volatile int debit;
    static volatile int credit;

    public static void main(String[] args) {
        // report transaction scheduler
        new Thread(() -> {

            for (int i = 0; i < 10; i++) {
                try {

                    lock.lock();
                    Stream<Integer> s = Arrays.stream(new int[] {1, 2, 3}).boxed();
                    s.sorted();
                    condition.await();

                    System.out.println(String.format("Report debit=%d, credit=%d", debit, credit));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }

        }).start();

        new Thread(() -> {

            for (int i = 0; i < 10; i++) {

                try {
                    Thread.sleep(1200);

                    lock.lock();

                    debit += 10;
                    credit += 10;

                    if (debit == credit) {
                        condition.signal();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }

        }).start();

    }
}
