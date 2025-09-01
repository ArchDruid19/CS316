from linked_queue import LinkedQueue

def main():
    test_queue = LinkedQueue()
    test_queue.push(10)
    test_queue.push(100)
    test_queue.push(1000)
    test_queue.printListIterative()
    print()
    test_queue.printListRecursive(test_queue.head)

if __name__ == "__main__":
    main()  
