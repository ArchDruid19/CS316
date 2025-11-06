from linked_queue import LinkedQueue
from linked_stack import LinkedStack

def main():
    test = LinkedStack()
    test2 = LinkedQueue()
    for i in range(0, 11):
        test.push(i)
        test2.enqueue(i)

    test.printStackIter()
    test.pop()
    test.pop()
    test.pop()
    test.pop()
    test.printStackIter()

    test2.printListIterative()
    test2.dequeue()
    test2.dequeue()
    test2.dequeue()
    test2.dequeue()
    test2.printListIterative()


if __name__ == "__main__":
    main()  
