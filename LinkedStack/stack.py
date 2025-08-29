from node import Node

class Stack:
    def __init__(self):
        self.head = None

    def push(self, value): # O(1)
        temp = Node(value)
        if self.head is None:
            self.head = temp
        else:
            temp.next = self.head
            self.head = temp

    def printStackRecursive(self, head):
        if head is None:
            return
        else:
            print(head.data)
            self.printStackRecursive(head.next)

    def printStackIter(self): # O(n)
        temp = self.head
        while temp:
            print(temp.data)
            temp = temp.next

    def isEmpty(self):
        return self.head == None