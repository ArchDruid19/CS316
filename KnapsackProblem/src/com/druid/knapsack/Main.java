package com.druid.knapsack;
// This is the knapsack problem without using dynamic programming

import java.util.ArrayList;

// Step 1. Create all combinations of the given Knapsack items and return them as a

// 2D array

// Step 2. Go through each array (combination) in the 2D array and compute the total weight's and values
// for each array (combination). If the weight of an array > our knapsack weight limit, toss it out; else,
// add it to a new list that contains ONLY combinations under or at the weight limit.

// Step 3. Go through the list and find the combination with the greatest total value

public class Main {
    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> test_array = new ArrayList<>();

        ArrayList<Integer> annoyed = new ArrayList<Integer>();

        annoyed.add(1);
        annoyed.add(10);

        test_array.add(annoyed);

        System.out.println(test_array.get(0).get(1));

    }

}
