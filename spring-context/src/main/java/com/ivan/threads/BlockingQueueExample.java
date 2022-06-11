package com.ivan.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueExample {
    public static void main(String[] args) {
        LinkedBlockingDeque<String> dequeue1 = new LinkedBlockingDeque<>();
        LinkedBlockingDeque<String> queue1 = new LinkedBlockingDeque<>();
        ArrayBlockingQueue<String> queue2 = new ArrayBlockingQueue<>(22);
    }
}
