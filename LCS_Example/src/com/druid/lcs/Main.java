package com.druid.lcs;

public class Main {
    public static void main(String[] args) {
        String first = "bcd";
        String second = "abcd";

        int longest = lcsWrapper(first, second);

        System.out.println(longest);
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
}
