package com.druid.tree;

public class BinaryTreeNode {
    // Each node has a data value and a left and right pointer to another node
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode (Integer data) {
        // Each node is created with some integer and no children 
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
