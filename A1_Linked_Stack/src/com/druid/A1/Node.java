package com.druid.A1;

/*
 * Data contains an integer while next containers a pointer
 * to the next node in the list
 * 
 * Using the Integer wrapper class so its possible to return null
 */

public class Node {
    Integer data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
