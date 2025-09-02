package com.druid.Leet206;

public class Main {
    public static void main(String[] args) {
        // Wow thats bad!
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        reverseList(head);
    }

    public static ListNode reverseList(ListNode head) {
        // Go to the end of the list, then starting from the back
        // point them in reverse
        ListNode reversed_head = head;


        while (reversed_head != null) {
            
        }


        return reversed_head;
    }
}
