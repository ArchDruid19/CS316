package com.druid.knapsack;
// This is the knapsack problem without using dynamic programming

public class Main {
    public static void main(String[] args) {

        int[] weights = { 1, 3, 4, 5 };
        int[] values = { 1, 4, 5, 7 };
        int max_weight = 7;

        int x = recKnapsack(weights.length, values, weights, max_weight);
        
        // System.out.println(weights[weights.length]);
        System.out.println(x);
        
    }

    public static int recKnapsack(int n, int[] values, int[] weight, int max_weight) {
        if (n <= 0 || max_weight == 0) {
            return 0;
        }

        if (weight[n - 1] > max_weight) {
            return recKnapsack(n - 1, values, weight, max_weight);
        } else {
            int pick = values[n - 1] + recKnapsack(n - 1, values, weight, max_weight - weight[n - 1]);
            int not_pick = recKnapsack(n - 1, values, weight, max_weight);
            if (pick > not_pick) {
                return pick;
            } else {
                return not_pick;
            }
            
        }

    }

}
