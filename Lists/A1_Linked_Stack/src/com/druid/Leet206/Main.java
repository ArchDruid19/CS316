package com.druid.Leet206;

public class Main {
    public static void main(String[] args) {
        // Wow thats bad!
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode meme = reverseList(head);

        printList(head);
        System.out.println();
        printList(meme);
        
    }

    public static ListNode reverseList(ListNode head) {
        // Go to the end of the list, then starting from the back
        // point them in reverse
        ListNode reversed_head = null;

        while (head != null) {
            ListNode temp = head.next;
            head.next = reversed_head;
            reversed_head = head;
            head = temp;
        }

        return reversed_head;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
