package com.druid.tree;

public class Main {
    public static void main(String[] args) {
        Tree test_tree = new Tree();
        test_tree.addToRight(new Node(10));
        test_tree.addToRight(new Node(20));
        test_tree.printTree();
        
    }
}
