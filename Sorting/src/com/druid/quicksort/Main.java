package com.druid.quicksort;

public class Main {
    public static void main(String[] args) {
        int[] arr = { 10, 5, 8, 9, 3, 6, 15, 12, 16, Integer.MAX_VALUE };
        quickSort(arr);

        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    public static int parition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        System.out.printf("Paritioning from idx=%s to idx=%s , with a pivot=%s \n", low, high, pivot);
        while (i < j) {
            while (i <= high && arr[i] <= pivot) {
                i += 1;
            }

            while (j > low && arr[j] > pivot) {
                j -= 1;
            }

            if (i < j) {
                System.out.printf("Swapping pivot arr[%s]=%s with arr[%s]=%s \n", low, arr[low], j, arr[j]);
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        System.out.printf("Swapping pivot arr[%s]=%s with arr[%s]=%s \n", low, arr[low], j, arr[j]);
        int temp_low = arr[low];
        arr[low] = arr[j];
        arr[j] = temp_low;

        return j;
    }

    public static void quickSortHelper(int[] arr, int low, int high, int depth) {
        if (low < high) {
            // System.out.printf("\n %s \n Quicksort called on subarray idx {%s}:{%s} ->",);
            int j = parition(arr, low, high);
            System.out.printf("Pivot idx returned=%s \n %s \n", j, "-".repeat(40));

            quickSortHelper(arr, low, j - 1, depth + 1);
            quickSortHelper(arr, j + 1, high, depth + 1);
        }
    }

    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1, 0);
    }

}
