package com.druid.tree;

import java.util.Scanner;

import com.druid.tree.BinaryTree.TraversalMode;
import com.druid.tree.BinaryTree.TraversalType;

public class Main {
    public static void main(String[] args) {
        BinaryTree test_tree = new BinaryTree();
        Integer[] numbers = {23, 10, 30, 5, 15, 25, 40, 1, 8};

        for (int i = 0; i < numbers.length; i++) {
            test_tree.insert(numbers[i], TraversalMode.ITERATIVE);
        }

        System.out.println(test_tree.printTree(test_tree.root, TraversalType.LVR));

        for (Integer i = test_tree.getMinTreeValue(), j = 0; i < test_tree.getMaxTreeValue() + 1; i ++) {
            if (j % 10 == 0) {
                System.out.println();
            }
            System.out.printf("%-5s ", test_tree.searchTree(i, TraversalMode.RECURSIVE, test_tree.getRoot()));
            j++;
        }
    }

    public static void printAllOptions(BinaryTree tree) {
        for (TraversalType i: TraversalType.values()) {
            System.out.println(i);
            System.out.println(tree.printTree(tree.getRoot(), i));
        }

    }
}
