package com.druid.LCS;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String first = "jello";
        String second = "yellow";

        calculateLCSTableWrapper(first, second);
    }

    // Solving using DP
    public static void calculateLCSTable(String a, String b, int[][] table) {
        // The first column must contain all 0's
        for (int i = 0; i <= a.length(); i++) {
            table[i][0] = 0;
        }

        // The first row must contain all 0's
        for (int j = 0; j <= b.length(); j++) {
            table[0][j] = 0;
        }

        // Iterate through the table row by row and check if the individual characters in each
        // string match. If they do, then table[i][j] = 1 + table[i - 1][j - 1]
        // If the chars dont match, then table[i][j] = Max(table[i - 1][j] OR table[i][j
        // - 1])
        // Start filling the table at idx=[1,1] because the first row and column will
        // always be 0
        for (int i = 1; i < table.length; i++) {
            for (int j = 1; j < table[i].length; j++) {
                System.out.printf("comparing %s with %s: %s \n", a.charAt(i - 1), b.charAt(j - 1),
                        a.charAt(i - 1) == b.charAt(j - 1));
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    table[i][j] = 1 + table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        /*
         * Now that the table is created, we need to backtrack to find the actual
         * characters that make up the LCS
         * We must start from the bottom right corner of the table and work towards the
         * top
         * 
         * The algorithm to backtrack is almost EXACTLY the same as the way the table is
         * filled
         * When we match on a character in both row and column, we move diagonally to
         * the left which follows as when a
         * character matches in the table filling process, we take the element diagonal
         * to one being examined and add 1 (1 + table[i - 1][j - 1] from line 36)
         * Similarly, when we backtrack and the characters dont match, we look at either the top or left cell
         * and determin which one is larger to find where we came from: Math.max(table[i - 1][j], table[i][j - 1]) means
         * the maximum value of the left OR top cell from the one being examined
         */

        // Create two index variables, row and length, that are the lengths of the
        // strings provided
        int row = a.length();
        int col = b.length();
        // Array where we add either 0 or 1 to find the string
        ArrayList<Boolean> res = new ArrayList<>();

        while (row != 0 && col != 0) {
            if (a.charAt(row - 1) == b.charAt(col - 1)) {
                res.add(true);
                // If the characters match, then we add the character to a list and move
                // diagonally
                row -= 1;
                col -= 1;
            } else {
                if (table[row - 1][col] > table[row][col - 1]) {
                    // If the value in the cell to the left is greater than the value in the cell
                    // above it, we move left
                    // and mark that the characters were not a match
                    res.add(false);
                    row -= 1;
                } else {
                    // If the value in the cell above is greater, we move up and mark that the
                    // characters were not a match
                    res.add(false);
                    col -= 1;
                }
            }
        }

        for (boolean items : res) {
            System.out.printf("%-8s ", items);
        }
        System.out.println();

        printLCSTable(table);

    }

    public static void calculateLCSTableWrapper(String a, String b) {
        // Create a table with dimensions [a.length() + 1] X [b.length() +1] with 1
        // extra 'padding' as the first row and column are
        // all 0's
        int[][] table = new int[a.length() + 1][b.length() + 1];
        calculateLCSTable(a, b, table);
    }

    public static void printLCSTable(int[][] table) {
        // Print the table for debugging/visual purposes
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%-8s", table[i][j] + " ");
            }
            System.out.println();
        }
    }

}
