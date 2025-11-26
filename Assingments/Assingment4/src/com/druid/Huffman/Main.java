package com.druid.Huffman;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        huffmanCompression("Banana Bandana");
    }

    public static Map<Character, String> huffmanCompression(String a) {
        /*
         * Step 1. Find the number of times each character appears in the string
         * Use a dictionary (Hashmap) to assign count occurences to each letter
         * Maps also dont allow duplicate keys which is perfect for storing the letter
         * occurences
         */
        Map<Character, Integer> letter_occurences = new HashMap<>();

        // We will only be worrying about lower case strings per the requirments of the
        // assingment
        a = a.toLowerCase();

        for (int i = 0; i < a.length(); i++) {
            int count = 0;
            for (int j = 0; j < a.length(); j++) {
                System.out.println("Comparing " + a.charAt(i) + " With " + a.charAt(j));
                if (a.charAt(i) == a.charAt(j)) {
                    count++;
                }
            }
            letter_occurences.put(a.charAt(i), count);
            // System.out.println(count);
        }

        printHashMap(letter_occurences);

        /*
         * Step 2. Create a min-heap (PriorityQueue) that holds huffman nodes sorted by
         * frequency.
         */

        PriorityQueue<HuffmanNode> huffman_min_heap = new PriorityQueue<>();

        // We must convert each letter we got into a tree node and put them in a minimum
        // heap
        for (Map.Entry<Character, Integer> entry : letter_occurences.entrySet()) {
            // Create leaf nodes for each character
            HuffmanNode temp_node = new HuffmanNode(entry.getValue(), entry.getKey());
            // Add the nodes to the PriorityQueue where they will be sorted based on
            // frequency
            huffman_min_heap.add(temp_node);
        }

        /*
         * Step 3. Pop nodes out of the min heap 2 at a time and merge them to create
         * the Huffman Tree. The last node in the
         * min-heap will be the ROOT of the entire tree.
         */

        while (huffman_min_heap.size() != 1) {
            // Pop two nodes out of the heap: a left and right node
            HuffmanNode left_node = huffman_min_heap.poll();
            HuffmanNode right_node = huffman_min_heap.poll();

            // Create a parent node that will connect the left and right nodes and hold
            // their added frequencies
            HuffmanNode parent_node = new HuffmanNode(left_node.frequency + right_node.frequency);
            // Assign the left and right nodes to the parent node
            parent_node.left = left_node;
            parent_node.right = right_node;

            /*
             * Once the two minimum nodes are removed from the min-heap, they are replaced
             * by the combined node of the two (parent node)
             * CHECK Huffman Encoding powerpoint pg. 13
             */
            huffman_min_heap.add(parent_node);
        }

        /*
         * Step 4. Get the root of the Huffman tree so we can traverse and find the
         * variable-length bit codes for each character
         */

        HuffmanNode huffman_tree_root = huffman_min_heap.poll();
        Map<Character, String> code_dictionary = new HashMap<Character, String>();
        getCodeDictionary(huffman_tree_root, code_dictionary);
        printCodeDictionary(code_dictionary);
        computeHuffmanCompressionRatio(a, code_dictionary, letter_occurences);

        // Return the code dictionary so the end user can see what each letter was compressed into
        return code_dictionary;

    }

    // A post-order traversal of a tree will show leaf nodes first which is what we
    // are looking for
    public static void traverseLRVHelper(HuffmanNode root, String variable_bit_code, Map<Character, String> code_dict) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            /*
             * If the node being examined is a LEAF node (meaning it is a character node),
             * we add the leaf node character and the variable length bit code
             * to the code dictionary
             */
            code_dict.put(root.character, variable_bit_code);
            return;
        }
        // When we go left we add '0' to the variable length bit code
        traverseLRVHelper(root.left, variable_bit_code + "0", code_dict);
        // When we go right we add '1' to the variable length bit code
        traverseLRVHelper(root.right, variable_bit_code + "1", code_dict);
    }

    public static void getCodeDictionary(HuffmanNode root, Map<Character, String> code_dict) {
        traverseLRVHelper(root, "", code_dict);
    }

    public static void printHashMap(Map<Character, Integer> printable_map) {
        // Print the Hashmap (purely for testing)
        for (Map.Entry<Character, Integer> entry : printable_map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public static void printCodeDictionary(Map<Character, String> printable_map) {
        for (Map.Entry<Character, String> entry : printable_map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }

    public static double computeHuffmanCompressionRatio(String a, Map<Character, String> code_dictionary, Map<Character, Integer> letter_counts) {
        /*
         * Each character is 8 bits, so the original size is the length of the string
         * multiplied by 8
         */
        double num_bits_original = a.length() * 8;
        // Convert the values of the letter repitions map to an array
        Integer[] letter_reps = letter_counts.values().toArray(new Integer[0]);

        int letter_reps_idx = 0;
        double total_compressed_bit_size = 0;
        // For each variable bit in the code dictionary, multiply the size of the bit by
        // the total number of times the letter appears in the string 
        for (String variable_bits : code_dictionary.values()) {
            total_compressed_bit_size += variable_bits.length() * letter_reps[letter_reps_idx];
            letter_reps_idx++;
        }
        System.out.println(num_bits_original);
        System.out.println(total_compressed_bit_size);
        double compression_ratio = total_compressed_bit_size / num_bits_original;
        System.out.println(compression_ratio);
        return 0.0;
    }
}
