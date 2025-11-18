package com.druid.lcs;

public class OldCode {
    // Recursive implementation that doesnt really work because you cant backtrack the table easily
    public static int performLCSTable(char[] a, char[] b, int i, int j, int[][] table) {
        // Base case where we stop performing LCS
        if (i == a.length || j == b.length) {
            return 0;
        }

        // Check if the value is already in the table, and if it is, simply return it
        if (table[i][j] != 0) {
            return table[i][j];
        }

        // If string a's character matches string b's character, add 1 to the cell and
        // move i and j forward
        if (a[i] == b[j]) {
            return table[i][j] = 1 + performLCSTable(a, b, i + 1, j + 1, table);
        } else {
            // Else, set table[i][j] to be the maxmimum value when you either move i forward
            // 1 or j forward 1
            return table[i][j] = Math.max(performLCSTable(a, b, i + 1, j, table),
                    performLCSTable(a, b, i, j + 1, table));
        }
    }

    public static void lcsTableWrapper(String a, String b) {
        char[] string_a = a.toCharArray();
        char[] string_b = b.toCharArray();

        int[][] table = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = 0;
            }
        }

        performLCSTable(string_a, string_b, 0, 0, table);

        // Print the table
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%-6s", table[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Older version that doesnt use memo or dp
    public static int performLCS(char[] a, char[] b, int i, int j) {
        if (i >= a.length || j >= b.length) {
            return 0;
        }
        System.out.println("a[i] = " + a[i]);
        System.out.println("i = " + i);
        System.out.println("b[j] = " + b[j]);
        System.out.println("j = " + j);

        if (a[i] == b[j]) {
            return 1 + performLCS(a, b, i + 1, j + 1);
        } else {
            return Math.max(performLCS(a, b, i + 1, j), performLCS(a, b, i, j + 1));
        }
    }

    public static int lcsWrapper(String a, String b) {
        char[] string_a = a.toCharArray();
        char[] string_b = b.toCharArray();

        return performLCS(string_a, string_b, 0, 0);
    }
}
