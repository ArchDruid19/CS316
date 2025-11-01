package com.druid.lcs;

public class Main {
    public static void main(String[] args) {
        String first = "abcd";
        String second = "bd";

        lcsTableWrapper(first, second);
    }

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



    
    public static int performLCSTable(char[] a, char[] b, int i, int j, Integer[][] table) {
        if (i == a.length || j == b.length) {
            return 0;
        }

        // System.out.println(table[i][j]);

        if (table[i][j] != null) {
            return table[i][j];
        }

        if (a[i] == b[j]) {
            return table[i][j] = 1 + performLCSTable(a, b, i + 1, j + 1, table);
        } else {
            return table[i][j] = Math.max(performLCSTable(a, b, i + 1, j, table), performLCSTable(a, b, i, j + 1, table));
        }
    }

    public static void lcsTableWrapper(String a, String b) {
        char[] string_a = a.toCharArray();
        char[] string_b = b.toCharArray();

        Integer[][] table = new Integer[a.length() + 1][b.length() + 1];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = null;
            }
        }

        performLCSTable(string_a, string_b, 0, 0, table);

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                System.out.printf("%-6s", table[i][j] + " ");
            }
            System.out.println();
        }
        

    }
}
