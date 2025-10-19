package com.druid.lcs;

public class Main {
    public static void main(String[] args) {
        String first = "bd";
        String second ="abcd";

        int longest = performLCS(first, second, 0, 0);

        System.out.println(longest);
    }

    public static int performLCS(String a, String b, int i, int j) {
        char[] string_a = a.toCharArray();
        char[] string_b = b.toCharArray();

        if (i >= string_a.length || j >= string_b.length) {
            return 0;
        } else if (string_a[i] == string_b[j]) {
            return 1 + performLCS(a, b, i + 1, j + 1);
        } else {
            return Math.max(performLCS(a, b, i + 1, j), performLCS(a, b, i, j + 1));
        }
    }
}
