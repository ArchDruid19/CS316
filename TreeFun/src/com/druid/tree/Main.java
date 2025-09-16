package com.druid.tree;

public class Main {
    public static void main(String[] args) {
        Tree test_tree = new Tree();
        test_tree.addToRight(new Node(10));
        test_tree.addToRight(new Node(20));
        test_tree.addToLeft(new Node(100));
        test_tree.root.right.right = new Node(1000);
        System.out.println(test_tree.root.left.data);
        test_tree.root.left.right = new Node(55);
        test_tree.printTreeRecursiveWrapper();
        
    }
}
