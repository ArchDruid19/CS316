package com.druid.tree;

public class Tree {
    Node root;

    public Tree() {
        this.root = null;
    }

    public Tree(Node root) {
        this.root = root;
    }

    public boolean insertIterative(Node insert_node) {
        if (this.root == null) {
            this.root = insert_node;
        } else {
            Node previous_node = null;
            Node current_node = this.root;

            while (current_node != null) {
                previous_node = current_node;

                if (insert_node.data < current_node.data) {
                    current_node = current_node.left;
                } else if (insert_node.data > current_node.data) {
                    current_node = current_node.right;
                } else if (insert_node.data.equals(current_node.data)) {
                    return false;
                } else {
                    return false;
                }
            }

            if (insert_node.data < previous_node.data) {
                previous_node.left = insert_node;
            } else {
                previous_node.right = insert_node;
            }
        }
        return true;
    }

    // Inorder
    public String printTreeLVR(Node tree_root) {
        if (tree_root == null) {
            return "";
        }
        return printTreeLVR(tree_root.left) + tree_root.data + " " + printTreeLVR(tree_root.right);
    }

    public String printTreeRVL(Node tree_root) {
        if (tree_root == null) {
            return "";
        }
        return printTreeRVL(tree_root.right) + tree_root.data + " " + printTreeRVL(tree_root.left);
    }

    // Preorder
    public String printTreeVLR(Node tree_root) {
        if (tree_root == null) {
            return "";
        }
        return tree_root.data + " " + printTreeVLR(tree_root.left) + printTreeVLR(tree_root.right);
    }

    public String printTreeVRL(Node tree_root) {
        if (tree_root == null) {
            return "";
        }
        return tree_root.data + " " + printTreeVRL(tree_root.right) + printTreeVRL(tree_root.left);
    }

    // Postorder
    public String printTreeLRV(Node tree_root) {
        if (tree_root == null) {
            return "";
        }
        return printTreeLRV(tree_root.left) + printTreeLRV(tree_root.right) + tree_root.data + " ";
    }

    public String printTreeRLV(Node tree_root) {
        if (tree_root == null) {
            return "";
        }
        return printTreeRLV(tree_root.right) + printTreeRLV(tree_root.left) + tree_root.data + " ";
    }

    public enum OrderOption {
        LVR,
        RVL,
        VLR,
        VRL,
        LRV,
        RLV
    }

    public String printTree(Node tree_root, OrderOption option) {
        String sequence = "";
        switch (option) {
            case LVR:
                if (tree_root == null) {
                    return "";
                }
                sequence = printTree(tree_root.left, OrderOption.LVR) + tree_root.data + " " + printTree(tree_root.right, OrderOption.LVR);

            case RVL:

                break;

            default:
            break;
        }

        return sequence;
    }
}
