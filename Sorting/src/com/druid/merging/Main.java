package com.druid.merging;

public class Main {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4};
        int[] b = {45, 21, 23, 10};

        merge(a, b);
        
    }

    public static int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] sorted_array = new int[a.length + b.length];

        while (i < a.length && j < b.length) {
            System.out.println(a[i]);
            System.out.println(b[j]);
            i++;
            j++;
        }
        return null;
    }
}
