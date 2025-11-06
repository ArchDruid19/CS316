package com.druid.A1;
/*
 * Stack implemented using a linked list | new nodes are pushed on the head, and popped
 * off the head
 * 
 */

public class LinkedStack {
    Node head;

    public LinkedStack() {
        this.head = null;
    }

    public void push(Integer value) {
        /*
         * Adds a value to the start of the list by setting the old head to the next
         * value
         * of the node being added, and then setting the head to the node being added.
         */
        Node temp_node = new Node(value);

        if (this.head == null) {
            this.head = temp_node;
        } else {
            temp_node.next = this.head;
            this.head = temp_node;
        }
    }

    public Integer pop() {
        /*
         * Removes and returns the top value in the list
         * Sets the head of the list to the next Node in the list,
         * which severs the connection between the old head
         * and the entire list 
         */
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
        /*
         * Returns the top value in the list unless the list is empty
         */ 
        if (this.head == null) {
            return null;
        } else {
            return this.head.data;
        }
    }

    public boolean isEmpty() {
        /*
         * Checks if the list is empty by checking if the head
         * has items in it. If the head is null, then the list must
         * be empty. 
         */        
        return this.head == null;
    }

    public int getSizeRecursive(Node head, int size) {
        /*
         * For every recusive call until the parameter is null, add 1
         */ 
        if (head == null) {
            return size;
        }
        return getSizeRecursive(head.next, size + 1);

    }

    public int getSizeIterative() {
        /*
         * Use a temporary pointer to the head
         * to traverse the list, at each node adding 1
         * to a counter
         */
        Node temp_node = this.head;
        int count = 0;
        while (temp_node != null) {
            count++;
            temp_node = temp_node.next;
        }

        return count;
    }

    public void displayRecursive(Node head) {
        /*
         * For each recursive call we print the nodes data value and a space
         * until we reach a null node, in which case we print a line
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
        /*
         * Walk through the list and print each Node's data member until we reach the
         * end
         */
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
         * Checks if the parameters data member is equal to what is being searched,
         * otherwise
         * it will build AR until it either traverses the list and nothing is found, in
         * which
         * case it returns false, or the value is found and it returns true. O(n) time
         * complexity
         */
        if (head == null) {
            return false;
        }
        if (head.data.equals(number)) {
            return true;
        }
        return containsElementRecursive(number, head.next);
    }

    public boolean containsElementIterative(Integer number) {
        /*
         * Walk through the list until we either find a number that matches
         * the value inputted, else return false to signify that
         * the value was not found. O(n) time complexity
         */
        Node temp_current_node = this.head;
        while (temp_current_node != null) {
            if (temp_current_node.data.equals(number)) {
                return true;
            }
            temp_current_node = temp_current_node.next;
        }
        return false;
    }

    public void clearListIteratively() {
        /*
         * Disconnects the head from the list which
         * effectivly removes all entries
         */
        //this.head = null;
        while (this.head != null) {
            this.head = this.head.next;
        }
    }

    public void clearListRecursive(Node head) {
        /*
         * Walk through the list all the way to the back,
         * / then set each Node to null as activation records are popped
         */
        if (head == null) {
            this.head = null;
            return;
        }
        clearListRecursive(head.next);
        head.next = null;
    }
}
