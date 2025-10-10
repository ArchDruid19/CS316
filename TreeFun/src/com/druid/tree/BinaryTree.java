package com.druid.tree;

public class BinaryTree {
    protected BinaryTreeNode root;

    public enum TraversalMode {
        // enum for choosing to traverse either iterativly or recursivly
        ITERATIVE,
        RECURSIVE
    }

    public enum TraversalType {
        // enum for choosing which traversal type to use
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

    public void insert(int data) {
        /*
         * C++ Implementation of inserting from the book (pg. 241, figure 6.23) written
         * in Java.
         * Traverse the tree going left if the data in the inserted node
         * is less than the current node and right if the node being inserted is larger
         * than
         * the current node.
         * At the end current will be null and previous will be a pointer to the node we
         * last traversed, which is then assinged either a left or right child
         */

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
        } else if (data > previous.data) {
            previous.right = new BinaryTreeNode(data);
        } else {
            System.out.println("ERROR: Cant insert duplicates!");
        }

    }

    public boolean searchTree(int search_data, TraversalMode option, BinaryTreeNode root) {
        /*
         * Searches the tree by comparing the value we are searching for with
         * a value in the tree; going left if the value is less than the node
         * or right if it is greater than the node. If we find a node whose
         * data field matches the data field of the search, we return true.
         * If we get to a leaf node then the search ends as there is no
         * more nodes to compare to.
         */
        switch (option) {
            case ITERATIVE:
                BinaryTreeNode current_node = this.root;
                while (current_node != null) {
                    if (search_data == current_node.data) {
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
                } else if (root.data == search_data) {
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
        /*
         * The same thing as getting the largest value except
         * we traverse down the left spine
         */
        BinaryTreeNode current = this.root;
        BinaryTreeNode parent = null;

        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent.data;
    }

    public String getTraversalSequence(BinaryTreeNode tree_root, TraversalType option) {
        /*
         * Create a string sequence that contains the order in which numbers
         * are traversed for the given traversal type.
         * To traverse for any type simply follow the letters in the abbreviation;
         * for LVR; recurse left -> print the node -> recurse right
         * for RVL; recurse right -> print the node -> recurse left etc...
         */
        String sequence = "";
        if (tree_root == null) {
            return "";
        }
        switch (option) {
            case LVR:
                sequence = getTraversalSequence(tree_root.left, TraversalType.LVR) + tree_root.data + " "
                        + getTraversalSequence(tree_root.right, TraversalType.LVR);
                break;
            case RVL:
                sequence = getTraversalSequence(tree_root.right, TraversalType.RVL) + tree_root.data + " "
                        + getTraversalSequence(tree_root.left, TraversalType.RVL);
                break;
            case VLR:
                sequence = tree_root.data + " " + getTraversalSequence(tree_root.left, TraversalType.VLR)
                        + getTraversalSequence(tree_root.right, TraversalType.VLR);
                break;
            case VRL:
                sequence = tree_root.data + " " + getTraversalSequence(tree_root.right, TraversalType.VRL)
                        + getTraversalSequence(tree_root.left, TraversalType.VRL);
                break;
            case LRV:
                sequence = getTraversalSequence(tree_root.left, TraversalType.LRV)
                        + getTraversalSequence(tree_root.right, TraversalType.LRV)
                        + tree_root.data + " ";
                break;
            case RLV:
                sequence = getTraversalSequence(tree_root.right, TraversalType.RLV)
                        + getTraversalSequence(tree_root.left, TraversalType.RLV)
                        + tree_root.data + " ";
                break;
            default:
                for (TraversalType i : TraversalType.values()) {
                    System.out.print(i + " ");
                }
                System.out.println();
                break;
        }
        return sequence;
    }
}
