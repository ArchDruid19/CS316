package com.druid.LCS;

public class Main {
    public static void main(String[] args) {
        String first = "bd";
        String second = "abcd";

        calculateLCSTableWrapper(first, second);
    }

    // Solving using bottom up DP (Best way that actually works)
    public static void calculateLCSTable(String a, String b, int[][] table) {
        // The first column must contain all 0's
        for (int i = 0; i <= a.length(); i++) {
            table[i][0] = 0;
        }

        // The first row must contain all 0's
        for (int j = 0; j <= b.length(); j++) {
            table[0][j] = 0;
        }

        // Print the table at the end
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%-6s", table[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void calculateLCSTableWrapper(String a, String b) {
        // Create the a x b table with 1 extra 'padding' as the first row and column are
        // all 0's
        int[][] table = new int[a.length() + 1][b.length() + 1];
        calculateLCSTable(a, b, table);
    }

}
