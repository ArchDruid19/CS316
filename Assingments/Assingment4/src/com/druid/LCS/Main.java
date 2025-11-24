package com.druid.LCS;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String first = "jello";
        String second = "yellow";

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

        // Go through the table and check if the individual characters in each string match. If they do, then table[i][j] = 1 + table[i - 1][j - 1]
        // If the chars dont match, then table[i][j] = Max(table[i - 1][j] OR table[i][j - 1])
        // Start filling the table at idx=[1,1] because the first row and column will always be 0
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                System.out.println("Comparing " + a.charAt(i - 1) + " With " + b.charAt(j - 1));
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        // Now that the table is created, we need to backtrack to find the actual characters that make up the LCS
        // We must start from the bottom right corner of the table and work towards the top

        // Create two index variables, row and length, that are the lengths of the strings provided
        int row = a.length();
        int col = b.length();
        // Array where we add either 0 or 1 to find the string
        ArrayList<Boolean> res = new ArrayList<>();

        while (row > 0 && col > 0) {
            if (a.charAt(row - 1) == b.charAt(col - 1)) {
                res.add(true);
                // If the characters match, then we add the character to a list and move diagonally
                row -= 1;
                col -= 1;
            } else {
                if (table[row - 1][col] > table[row][col - 1]) {
                    // If the value in the cell to the left is greater than the value in the cell above it, we move left
                    res.add(false);
                    row -= 1;
                } else {
                    // If the value in the cell above is greater, we move up
                    res.add(false);
                    col -= 1;
                }
            }
        }

        for (boolean items : res) {
            System.out.print(items + " ");
        }
        System.out.println();

        // Print the table at the end
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%-6s", table[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static void calculateLCSTableWrapper(String a, String b) {
        // Create a table with dimensions [a.length() + 1] X [b.length() +1] with 1 extra 'padding' as the first row and column are
        // all 0's
        int[][] table = new int[a.length() + 1][b.length() + 1];
        calculateLCSTable(a, b, table);
    }

}
