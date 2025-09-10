package com.druid.A1;

public class LinkedQueue {
    Node head;

    public LinkedQueue() {
        this.head = null;
    }

    public void enqueue(Integer data) {
        // Must push new members into the back (like a line at the store)
        Node temp_node = new Node(data);
        if (head == null) {
            this.head = temp_node;
        } else {
            Node current_node = this.head;
            while (current_node.next != null) { // Go to the tail and then point tail.next to the node being added
                current_node = current_node.next;
            }
            // if we assign a tail in the constructor it is possible to do this operation in
            // constant time
            current_node.next = temp_node;
        }
    }

    public Integer dequeue() {
        // First condition: the list is empty
        if (this.head == null) {
            System.out.println("The list is empty!");
            return null;
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

    public Integer peek() {
        if (this.head != null) {
            return this.head.data;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public int getListSizeRecursive(Node head) {
        // Return 0 once we traverse the entire list, else, keep adding 1 for every
        // recursive call
        if (head == null) {
            return 0;
        }
        return 1 + getListSizeRecursive(head.next);
    }

    public int getListSizeIterative() {
        Node temp_node = this.head;
        int count = 0;
        while (temp_node != null) {
            count++;
            temp_node = temp_node.next;
        }

        return count;
    }

    public void displayRecursive(Node head) {
        if (head == null) {
            System.out.println();
        }
        if (head != null) {
            System.out.print(head.data + " ");
            displayRecursive(head.next);
        }
    }

    public void displayIterative() {
        if (this.isEmpty()) {
            System.out.println("The list is empty!");
        }
        Node temp_node = this.head;
        while (temp_node != null) {
            System.out.println(temp_node.data);
            temp_node = temp_node.next;

        }
    }

    public boolean listContainsRecursive(Integer value, Node head) {
        if (head == null) {
            return false;
        }
        if (head.data.equals(value)) {
            return true;
        }
        return listContainsRecursive(value, head.next);
    }

    public boolean listContainsIterative(Integer value) {
        Node temp_node = this.head;
        while (temp_node != null) {
            if (temp_node.data.equals(value)) {
                return true;
            }
            temp_node = temp_node.next;
        }
        return false;
    }

    public Integer getRearElementRecursive(Node head) {
        if (head.next == null) {
            return head.data;
        }
        return getRearElementRecursive(head.next);
    }

    public Integer getRearElementIterative() {
        Node temp_node = this.head;
        while (temp_node.next != null) {
            temp_node = temp_node.next;
        }
        return temp_node.data;
    }

    public void clearListRecursive(Node node) {
        if (node == null) {
            this.head = null;
            return;
        }
        clearListRecursive(node.next);
        node.next = null;

    }

    public void clearListIterative() {
        Node next;
        while (this.head != null) {
            next = this.head.next; // Make a temporary Node to hold the next Node
            this.head.next = null; // Make the next node null
            this.head = next; // Make the head the copy we made earlier
        }
    }
}
