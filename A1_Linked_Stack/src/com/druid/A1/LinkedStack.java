package com.druid.A1;

public class LinkedStack {
    Node head;

    public LinkedStack() {
        this.head = null;
    }

    public void push(int value) {
        // Adds a value to the top of the list
        Node temp_node = new Node(value);

        if (this.head == null) {
            this.head = temp_node;
        } else {
            temp_node.next = this.head;
            this.head = temp_node;
        }
    }

    public Integer pop() {
        // Removes and returns the top value in the list
        if (this.head == null) {
            System.out.println("The list is empty!");
            return null;
        } else {
            int temp_num = this.head.data;
            this.head = this.head.next;
            return temp_num;
        }
    }

    public int peek() {
        // Returns the top value in the list
        if (this.head == null) {
            return -1;
        } else {
            return this.head.data;
        }
    }

    public boolean isEmpty() {
        // Checks if the list is empty
        return this.head == null;
    }

    public void displayIterative() {
        if (this.head == null) {
            System.out.println("The list is empty!");
        }
        Node temp_node = this.head;
        while (temp_node != null) {
            System.out.println(temp_node.data);
            temp_node = temp_node.next;
        }
    }

    public void displayRecursive(Node head) {
        if (head != null) {
            System.out.println(head.data);
            displayRecursive(head.next);
        }
    }

    public void contains(int name, Node head) {
        if (head == null) {
            return;
        }
        if (head.data == name) {
            System.out.println("found!");
        }
        contains(name, head.next);

    }

    public int size(Node head) {
        // For every recusive call until the head is null, add 1
        if (head == null) {
            return 0;
        }
        return 1 + size(head.next);
    }

    public void clearIteratively() {
        while (this.head != null) {
            this.head = this.head.next;
        }
    }

    public void clearRecursive(Node head) {
        if (head == null) {
            return;
        }
        this.head = this.head.next;
        clearRecursive(head.next);
    }
}
