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

    public Integer peek() {
        // Returns the top value in the list
        if (this.head == null) {
            return null;
        } else {
            return this.head.data;
        }
    }

    public boolean isEmpty() {
        // Checks if the list is empty
        return this.head == null;
    }

    public int getSizeRecursive(Node head) {
        // For every recusive call until the parameter is null, add 1
        if (head == null) {
            return 0;
        }
        return 1 + getSizeRecursive(head.next);
    }

    public void displayRecursive(Node head) {
        /*
         * Display the parameters (Node) data value until it is null
         */
        if (head == null) {
            System.out.println();
        }
        if (head != null) {
            System.out.print(head.data + " ");
            displayRecursive(head.next);
        }
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

    public boolean containsElementRecursive(Integer number, Node head) {
        /*
         * Checks if the parameters data member is equal to what is being searched, otherwise
         * it will build AR until it either traverses the list and nothing is found, in which 
         * case it returns false, or the value is found and it returns true
         */
        if (head == null) {
            return false;
        }
        if (head.data.equals(number)) { // We have to do this becuse we are using Integer and not int
            return true;
        }
        return containsElementRecursive(number, head.next);
    }

    public void reverseListRecursive(Node node) {
        /*
         * Do recursive calls until we get to the end of the list, then as we are popping
         * AR, point the nodes backwards
         */
        if (node != null) {
            reverseListRecursive(node.next);
            this.head = node;
        }
    }

    public void reverseListIterative() {

    }

    public void clearListIteratively() {
        /*
         * At each node, set it to the head which disconnects it from
         * the previous node, Garbage collection should then free the memory
         * because there are no more references to that node anywhere
         */
        while (this.head != null) {
            this.head = this.head.next;
        }
    }

    public void clearListRecursive(Node head) {
        /* Walk through the list all the way to the back,
        / then set each Node to null as activation records are popped
        / but this makes NO sense (FIX THIS)
        */ 
        if (head == null) {
            this.head = null;
            return;
        }
        clearListRecursive(head.next);
        head.next = null;
    }
}
