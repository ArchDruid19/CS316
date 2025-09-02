package com.druid.A1;

public class LinkedStack {
    Node head;

    public LinkedStack() {
        this.head = null;
    }

    public void push(Person value) {
        // Adds a value to the top of the list
        Node temp_node = new Node(value);

        if (this.head == null) {
            this.head = temp_node;
        } else {
            temp_node.next = this.head;
            this.head = temp_node;
        }
    }

    public Person pop() {
        // Removes and returns the top value in the list
        if (this.head == null) {
            System.out.println("The list is empty!");
            return null;
        } else {
            Person temp_person = this.head.person;
            this.head = this.head.next;
            return temp_person;
        }
    }

    public Person peek() {
        // Returns the top value in the list
        if (this.head == null) {
            return null;
        } else {
            return this.head.person;
        }
    }

    public boolean isEmpty() {
        // Checks if the list is empty
        return this.head == null;
    }

    public void displayIterative() {
        Node temp_node = this.head;
        while (temp_node != null) {
            temp_node.person.displayPerson();
            temp_node = temp_node.next;
        }
    }

    public void displayRecursive(Node head) {
        if (head != null) {
            head.person.displayPerson();
            displayRecursive(head.next);
        }
    }
}
