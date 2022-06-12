package com.ivan.datastructures_and_algorithms;

import java.util.Arrays;

public class QuickSort {
    transient int a;
    public void sort(int[] arr, int low, int high) {
        if (low < high) {
            int ph = partition(arr, low, high);
            sort(arr, low, ph - 1);
            sort(arr, ph + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        i++;
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;

        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 55, 4};
        new QuickSort().sort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }

}
