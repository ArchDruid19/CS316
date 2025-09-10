package com.druid.recursion;
public class Main {
    public static void main(String[] args) {
        syracuseSequence(12);
    }

    public static void printDecending(int n) {
        if (n <= 0) {
            return;
        }
        System.out.println(n);
        printDecending(n - 1);
    }

    public static int sumNumbers(int n) {
        if (n == 1) {
            return 1;
        }
        if (n <= 0) {
            return 0;
        }
        return n + sumNumbers(n - 1);
    }

    public static void printString(String s, int i) {
        if (i == s.length()) {
            return;
        }
        System.out.println(s.charAt(i));
        printString(s, i + 1);
    }

    public static String reverseString(String s, int i) {
        if (i < 0) {
            return "";
        }
        return reverseString(s, i - 1) + s.charAt(i);
        
    }

    public static int addTwoPositiveNumbers(int a, int b) {
        if (b <= 0) {
            return a;
        }
        return addTwoPositiveNumbers(a + 1, b - 1);
    }

    public static int syracuseSequence(int n) {
        if (n <= 1) { // If n is less than or equal to 1, print 1
            System.out.println(1);
            return 1;
        }
        if (n % 2 == 0) { // If n is even, divide it by 2
            System.out.println((n));
            return syracuseSequence((n)/2);
        } else {
            System.out.println(n); // If n is odd, times it by 3 and add 1
            return syracuseSequence((3*n) + 1);
        }
    }
}
