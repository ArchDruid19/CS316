package com.druid.tree;

import com.druid.tree.Tree.OrderOption;

public class Main {
    public static void main(String[] args) {
        Tree test_tree = new Tree();

        test_tree.insertIterative(new Node(23));
        test_tree.insertIterative(new Node(10));
        test_tree.insertIterative(new Node(30));
        test_tree.insertIterative(new Node(5));
        test_tree.insertIterative(new Node(15));
        test_tree.insertIterative(new Node(25));
        test_tree.insertIterative(new Node(40));
        test_tree.insertIterative(new Node(1));
        test_tree.insertIterative(new Node(8));

        

        System.out.println(test_tree.printTree(test_tree.root, OrderOption.LVR));

    }
}
