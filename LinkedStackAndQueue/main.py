from linked_queue import LinkedQueue

def main():
    test = LinkedQueue()
    for i in range(0, 21):
        test.enqueue(i)

    test.printListRecursive(test.head)

if __name__ == "__main__":
    main()  
