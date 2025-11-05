package com.druid.mergesort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = { 54, 67, 32 };

        System.out.println("Array before merge sorting:");
        printArray(a);

        mergeSort(a);

        System.out.println("Array after merge sorting:");
        printArray(a);

    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low, mid + 1);
        int[] right = Arrays.copyOfRange(arr, mid + 1, high + 1);
        int i = 0;
        int j = 0;
        int k = low;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i += 1;
            } else {
                arr[k] = right[j];
                j += 1;
            }
            k += 1;
        }

        while (i < left.length) {
            arr[k] = left[i];
            i += 1;
            k += 1;
        }

        while (j < right.length) {
            arr[k] = right[j];
            j += 1;
            k += 1;
        }
    }

    public static void mergeSortHelper(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;

            mergeSortHelper(arr, low, mid);
            mergeSortHelper(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void mergeSort(int[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.printf("%-7s ", e);
        }
        System.out.println();
    }
}