package com.druid.recursion;

public class SyracuseSequence {

    public static void main(String[] args) {
        System.out.println(syracuseSequence(12));
    }

    public static String syracuseSequence(int n) {
        /*
         * Builds a string of the syracuse sequence for a given n.
         * The base case is when a number in the sequence is less than or equal to 1
         * The inductive case is when the number is either even or odd and greater than 1
         * in which case it will either return number/2 or 3*number + 1 until that number becomes
         * less than or equal to 1
         */
        if (n <= 1) {
            return "1";
        }
        if (n % 2 == 0) {
            return n + " " + syracuseSequence(n/2);
        } else {
           return n + " " + syracuseSequence((3*n) + 1);
        }
    }
    
}
