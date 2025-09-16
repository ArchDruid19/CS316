package com.druid.tree;

public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    public Tree(Node root) {
        this.root = root;
    }

    public void addToRight(Node right_node) {
        if (this.root == null) {
            this.root = right_node;
            return;
        }
        if (this.root.right == null) {
            this.root.right = right_node;
            return;
        }

        Node temp_node = this.root;
        while (temp_node.right != null) {
            temp_node = temp_node.right;
        }
        temp_node.right = right_node;
        
    }

    public void addToLeft(Node left_node) {
        if (this.root == null) {
            this.root = left_node;
            return;
        }
        if (this.root.left == null) {
            this.root.left = left_node;
            return;
        }

        Node temp_node = this.root;
        while (temp_node.left != null) {
            temp_node = temp_node.left;
        }
        temp_node.left = left_node;
    }

    public void printTree() {
        Node temp_node = this.root;

        while (temp_node != null) {
            System.out.print(temp_node.data + " ");
            temp_node = temp_node.right;

        }
        temp_node = this.root.left;
        while (temp_node != null) {
            System.out.print(temp_node.data + " ");
            temp_node = temp_node.left;
        }

        System.out.println();
    }

    public void printTreeRecursive(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        printTreeRecursive(root.right);
        printTreeRecursive(root.left);
    }

    public void printTreeRecursiveWrapper() {
        printTreeRecursive(this.root);
    }
    
}
