package com.druid.A1;

/*
 * Queue implemented using a linked list | new nodes are added to the back, and popped from the top
 */

public class LinkedQueue {
    Node head;

    public LinkedQueue() {
        this.head = null;
    }

    public void enqueue(Integer data) {
        /*
         * If the list is empty, simply asign the new node to the head.
         * If the list has items in it, go through the list until we reach the last node
         * and then asign the last nodes next value to the node being added.
         * 
         * This runs in O(n) time, but can be significantly improved by using a tail
         * pointer so the last node can be acsessed in O(1) time.
         */

        Node temp_node = new Node(data);
        if (head == null) {
            this.head = temp_node;
        } else {
            Node current_node = this.head;
            while (current_node.next != null) {
                current_node = current_node.next;
            }
            current_node.next = temp_node;
        }
    }

    public Integer dequeue() {
        /*
         * First condition: the list is empty, which means removal is impossible
         * 
         * Second condition: the list has 1 item, which means we make a copy of the data
         * in the node to return it and then set the head to null
         * 
         * Third condition: the list has more than 1 item, which means we move the head to the next
         * node which severs the connection between the old head and the list
         */

        if (this.head == null) {
            System.out.println("The list is empty!");
            return null;
        }
        Integer temp_num = this.head.data;

        if (this.head.next == null) {
            this.head = null;
        } else { // 
            this.head = this.head.next;
        }
        return temp_num;
    }

    public Integer peek() {
        /*
         * Return the data stored in the head to check what is going to be
         * removed
         */
        if (this.head != null) {
            return this.head.data;
        } else {
            return null;
        }
    }

    public boolean isEmpty() {
        /*
         * If the head is empty, then the list must be empty
         */
        return this.head == null;
    }

    public int getListSizeRecursive(Node head, int size) {
        // Return size once the head is null, else keep traversing the list
        // adding 1 to size after each method call
        if (head == null) {
            return size;
        }
        return getListSizeRecursive(head.next, size + 1);
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

    public void displayRecursiveBackwards(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        if (head != null) {
            displayRecursiveBackwards(head.next);
            System.out.print(head.data + " ");
            
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
        /*
         * The base case is when we reach the last element in the list, where
         * we just return its data value.
         */
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
