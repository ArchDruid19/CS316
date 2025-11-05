package com.druid.radixsort;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Unsorted Array:");
        int[] arr = { 237, 146, 259, 348, 152, 163, 235, 48, 36, 62 };
        printArray(arr);

        radixSortIterative(arr);
        System.out.println("Sorted Array:");
        printArray(arr);

    }

    public static int[] radixSortIterative(int[] arr) {
        int place = 1;
        int num_reps = getRepetitions(arr);
        int[] sorted_array = arr;
        // Create the band that will hold the numbers per place
        LinkedList<Integer>[] band = new LinkedList[10];

        // Initalize the list with LinkedLists that will acts as queues
        for (int i = 0; i < band.length; i++) {
            band[i] = new LinkedList<Integer>();
        }

        for (int reps = 0; reps < num_reps; reps++) {

            // Find where each number in the original list should go in the band
            for (int k = 0; k < arr.length; k++) {
                int place_idx = (arr[k] / place) % 10;
                band[place_idx].add(arr[k]);
            }

            int temp_pass_idx = 0;

            // Go to each cell in the band and pop each number, adding the popped number to the
            // sorted array
            for (int i = 0; i < band.length; i++) {
                // Pop each number out of the band, doing it until each cell is empty
                while (!band[i].isEmpty()) {
                    System.out.print(band[i].peek() + " ");
                    Integer temp_val = band[i].pop();
                    sorted_array[temp_pass_idx] = temp_val;
                    temp_pass_idx++;
                }
            }
            System.out.println();

            // Move left 1 digit
            place = place * 10;
        }
        return sorted_array;
    }






    public static int[] radixSortRecursive(int[] arr, int place, int repetitions) {
        // The array is sorted once all repitions have been done
        if (repetitions <= 0) {
            return arr;
        } else {
            // Create an array of LinkedLists that is each digit (0 - 9)
            LinkedList<Integer>[] band = new LinkedList[10];

            // Initalize each cell in the array with a LinkedList
            for (int i = 0; i < band.length; i++) {
                band[i] = new LinkedList<Integer>();
            }

            // Append each number in the array to a digit cell, treating each linked list
            // as a queue (if the number is 157, the first pass puts it in the 7 digit cell,
            // 2nd pass 5 digit cell etc...)
            // Use the formula (n / 10^k) for k = {0, 1, 2, 3...} to find the index to put
            // each number in, where k represents the the current pass
            for (int k = 0; k < arr.length; k++) {
                int place_idx = (arr[k] / place) % 10;
                band[place_idx].add(arr[k]);
            }

            // Create a temporary array that will hold each number in the order they are
            // presented in the band
            int[] temp_pass_ary = new int[arr.length];
            int temp_pass_idx = 0;
            for (int i = 0; i < band.length; i++) {
                for (int j = 0; j < band[i].size(); j++) {
                    System.out.print(band[i].get(j) + " ");
                    temp_pass_ary[temp_pass_idx] = band[i].get(j);
                    temp_pass_idx++;
                }
            }
            System.out.println();

            // After each pass, use the newly sorted array and check the digit to the left
            return radixSortRecursive(temp_pass_ary, place * 10, repetitions - 1);
        }
    }

    public static int[] radixSort(int[] arr) {
        return radixSortRecursive(arr, 1, getRepetitions(arr));
    }

    public static int getRepetitions(int[] arr) {
        if (arr == null) {
            return 0;
        } else {
            // Find the largest value in the array
            int largest_val = arr[0];
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > largest_val) {
                    largest_val = arr[i];
                }
            }

            int counter = 0;

            // Find how many digits the largest number is by repeadtly doing integer
            // division until largest_val becomes 0
            while (largest_val != 0) {
                largest_val = largest_val / 10;
                counter++;
            }
            return counter;
        }

    }

    public static void printArray(int[] arr) {
        for (int e : arr) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

}
