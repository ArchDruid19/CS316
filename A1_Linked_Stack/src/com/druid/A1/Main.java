package com.druid.A1;

public class Main {
    public static void main(String[] args) {
        LinkedQueue queue_1 = new LinkedQueue();
        LinkedStack stack_1 = new LinkedStack();
        

        stack_1.push(1);
        stack_1.push(2);
        stack_1.pop();
        queue_1.enqueue(1);
        queue_1.enqueue(2);


        stack_1.displayRecursive(stack_1.head);
    }
}
