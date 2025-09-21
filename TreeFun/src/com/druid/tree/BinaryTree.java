package com.druid.tree;

public class BinaryTree {
    protected BinaryTreeNode root;

    public enum TraversalMode {
        ITERATIVE,
        RECURSIVE
    }

    public enum TraversalType {
        LVR,
        RVL,
        VLR,
        VRL,
        LRV,
        RLV
    }

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(BinaryTreeNode root) {
        this.root = root;
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public void insert(Integer data, TraversalMode option) {
        /*
         * C++ Implementation from the book in Java
         * Traverse the tree going left if the data in the inserted node
         * is less than the current node and right if the node being inserted is larger
         * than
         * the current node.
         * At the end current will be null and previous will be a pointer to the node we
         * last traversed, which is then assinged either a left or right value
         */
        switch (option) {
            case ITERATIVE:
                BinaryTreeNode current = this.root;
                BinaryTreeNode previous = null;

                while (current != null) {
                    previous = current;

                    if (data < previous.data) {
                        current = current.left;
                    } else {
                        current = current.right;
                    }
                }

                if (this.root == null) {
                    this.root = new BinaryTreeNode(data);
                } else if (data < previous.data) {
                    previous.left = new BinaryTreeNode(data);
                } else {
                    previous.right = new BinaryTreeNode(data);
                }
                break;

            default:
                break;
        }
    }

    public boolean searchTree(Integer search_data, TraversalMode option, BinaryTreeNode root) {
        switch (option) {
            case ITERATIVE:
                BinaryTreeNode current_node = this.root;
                while (current_node != null) {
                    if (search_data.equals(current_node.data)) {
                        return true;
                    }
                    if (search_data < current_node.data) {
                        current_node = current_node.left;
                    } else {
                        current_node = current_node.right;
                    }
                }
                break;
            case RECURSIVE:
                if (root == null) {
                    return false;
                } else if (root.data.equals(search_data)) {
                    return true;
                } else if (search_data < root.data) {
                    return searchTree(search_data, TraversalMode.RECURSIVE, root.left);
                } else {
                    return searchTree(search_data, TraversalMode.RECURSIVE, root.right);
                }
            default:
                break;
        }
        return false;
    }

    public Integer getMaxTreeValue() {
        /*
         * Go down the right spine of the tree until current is null and parent is the
         * previous node that was visted which is the node with the largest
         * value
         */
        BinaryTreeNode current = this.root;
        BinaryTreeNode parent = null;

        while (current != null) {
            parent = current;
            current = current.right;
        }
        return parent.data;
    }

    public Integer getMinTreeValue() {
        BinaryTreeNode current = this.root;
        BinaryTreeNode parent = null;

        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent.data;
    }

    public String printTree(BinaryTreeNode tree_root, TraversalType option) {
        String sequence = "";
        if (tree_root == null) {
            return "";
        }
        switch (option) {
            case LVR:
                sequence = printTree(tree_root.left, TraversalType.LVR) + tree_root.data + " "
                        + printTree(tree_root.right, TraversalType.LVR);
                break;
            case RVL:
                sequence = printTree(tree_root.right, TraversalType.RVL) + tree_root.data + " "
                        + printTree(tree_root.left, TraversalType.RVL);
                break;
            case VLR:
                sequence = tree_root.data + " " + printTree(tree_root.left, TraversalType.VLR)
                        + printTree(tree_root.right, TraversalType.VLR);
                break;
            case VRL:
                sequence = tree_root.data + " " + printTree(tree_root.right, TraversalType.VRL)
                        + printTree(tree_root.left, TraversalType.VRL);
                break;
            case LRV:
                sequence = printTree(tree_root.left, TraversalType.LRV) + printTree(tree_root.right, TraversalType.LRV)
                        + tree_root.data + " ";
                break;
            case RLV:
                sequence = printTree(tree_root.right, TraversalType.RLV) + printTree(tree_root.left, TraversalType.RLV)
                        + tree_root.data + " ";
                break;
            default:
                for (TraversalType i : TraversalType.values()) {
                    System.out.print(i + " ");
                }
                break;
        }
        return sequence;
    }
}
