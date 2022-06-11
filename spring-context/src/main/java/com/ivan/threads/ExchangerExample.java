package com.ivan.threads;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExchangerExample {
    private static Exchanger<ArrayList<String>> exchanger = new Exchanger<ArrayList<String>>();

    public static void main(String[] args) {
        Executor e = Executors.newCachedThreadPool();
        e.execute(new Printer());
        e.execute(new Writter());
    }

    static class Writter implements Runnable {
        private ArrayList<String> arr = new ArrayList<>();
        private Scanner scanner = new Scanner(System.in);

        @Override
        public void run() {
            try {
                while (arr != null) {
                    while (arr.size() < 3) {
                        arr.add(scanner.nextLine());
                    }
                    arr = exchanger.exchange(arr);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Printer implements Runnable {
        private ArrayList<String> arr = new ArrayList<>();

        @Override
        public void run() {
            try {
                while (arr != null) {
                    while (!arr.isEmpty()) {
                        System.out.println(arr.remove(0));
                    }
                    arr = exchanger.exchange(arr);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
