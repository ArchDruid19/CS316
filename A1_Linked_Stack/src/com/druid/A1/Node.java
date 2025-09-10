package com.druid.A1;

public class Node {
    Integer data; // Using the integer wrapper class because somtimes we need to return null
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
