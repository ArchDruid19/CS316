package com.druid.A1;

public class Main {
    public static void main(String[] args) {
        LinkedQueue queue_1 = new LinkedQueue();
        LinkedStack stack_1 = new LinkedStack();
        
        for (Integer i = 1; i <= 10; i++) {
            stack_1.push(i);
            queue_1.enqueue(i);
        }
        queue_1.displayRecursive(queue_1.head);
        queue_1.displayRecursiveBackwards(queue_1.head);
        
        
    }
}
