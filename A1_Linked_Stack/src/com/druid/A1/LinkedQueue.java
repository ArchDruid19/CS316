package com.druid.A1;
// Change this to a singular link list, and then make the push method a while
// loop in O(n) time
public class LinkedQueue {
    Node head;

    public LinkedQueue() {
        this.head = null;
    }

    public void enqueue(int data) {
        // Must push new members into the back (like a line at the store)
        Node temp_node = new Node(data);
        if (head == null) {
            this.head = temp_node;
        } else {
            Node current_node = this.head;
            while (current_node.next != null) { // Go to the tail and then point tail.next to the node being added
                current_node = current_node.next;
            }
            // if we assign a tail in the constructor it is possible to do this operation in constant time
            current_node.next = temp_node;
        }
    }

    public int dequeue() {
        // First condition: the list is empty
        if (this.head == null) {
            System.out.println("The list is empty!");
            return -1;
        }
        // Second condition: the list has 1 item
        int temp_num = this.head.data;

        if (this.head.next == null) {
            this.head = null;
        } else { // Third condition: the list has more than 1 item
            this.head = this.head.next;
        }
        
        return temp_num;
    }

    public int peek() {
        if (this.head != null) {
            return this.head.data;
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void displayIterative() {
        Node temp_node = this.head;
        while(temp_node != null) {
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

    public int size(Node head) {
        if (head != null) {
            return 1 + size(head.next);
        }
        return 0;
        
    }

    public Node getRear(Node head) {
        if (head.next == null) {
            return head;
        }
       return getRear(head.next);
    }
}
