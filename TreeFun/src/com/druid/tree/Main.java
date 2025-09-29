package com.druid.tree;

import java.util.Scanner;

import com.druid.tree.BinaryTree.TraversalMode;
import com.druid.tree.BinaryTree.TraversalType;

public class Main {
    public static void main(String[] args) {
        BinaryTree test_tree = getTreeFromInput();
        printAllOptions(test_tree);
    }

    public static void printAllOptions(BinaryTree tree) {
        // Traverses the tree in all 6 differant ways 
        for (TraversalType i : TraversalType.values()) {
            System.out.println(i);
            System.out.println(tree.getTraversalSequence(tree.getRoot(), i));
        }
    }

    public static void searchAllValues(BinaryTree tree) {
        // Searches all values in the tree starting from the smallest value
        // and ending with the largest value, incrementing by 1 each time
        for (Integer i = tree.getMinTreeValue(), j = 0; i < tree.getMaxTreeValue() + 1; i++) {
            if (j % 10 == 0) {
                System.out.println();
            }
            System.out.printf("%-5s ", tree.searchTree(i, TraversalMode.RECURSIVE, tree.getRoot()));
            j++;
        }

    }

    public static BinaryTree getTreeFromInput() {
        // Grabs a line of user inputted numbers and inserts them into a binary tree
        Scanner input = new Scanner (System.in);
        BinaryTree return_tree = new BinaryTree();
        System.out.println("Enter a sequence of numbers seperated by a comma (i.e 5,4,21,3...)");
        String[] numbers_string = input.nextLine().split(",");

        for (int i = 0; i < numbers_string.length; i++) {
            int temp_number = Integer.parseInt(numbers_string[i]);
            return_tree.insert(temp_number);
        }
        input.close();
        return return_tree;
    }
}
