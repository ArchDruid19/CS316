from stack import Stack

def main():
    test_stack = Stack()
    print(test_stack.isEmpty())
    test_stack.push(10)
    test_stack.push(100)
    test_stack.push(1000)
    test_stack.printStackRecursive(test_stack.head)
    print()
    test_stack.pop()
    test_stack.printStackIter()
    print(test_stack.isEmpty())

if __name__ == "__main__":
    main()  
