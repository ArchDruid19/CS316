package com.druid.Huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // Step 1. Find the number of times each character appears in the string
        // Use a dictionary (map in modern Java) to assign count occurences to each letter
        // Maps also dont allow duplicate keys which is perfect for storing the letter occurences using the counting method I am doing
        Map<Character, Integer> letter_occurences = new HashMap<>();

        String a = "Saginaw";
        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            System.out.println(a.charAt(i));
            for (int j = 0; j < a.length(); j++) {
                System.out.println("Comparing " + a.charAt(i) + " With " + a.charAt(j));
                if (a.charAt(i) == a.charAt(j)) {
                    count++;
                }
            }
            letter_occurences.put(a.charAt(i), count);
            System.out.println(count);
        }

        for (Map.Entry<Character, Integer> entry : letter_occurences.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Now, we use a min heap to get the smallest elements in order to build the tree
        // PriorityQueue min_heap 

    }
}
