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

    def pop(self): # O(1)
        if self.head is None:
            print("The list is empty!")
            return None
        else:
            temp_node = self.head
            self.head = temp_node.next
            return temp_node;

    def peek(self):
        return self.head    
    
    def isEmpty(self):
        return self.head == None        

    def printStackRecursive(self, head):
        # Similar to how I have seen it done with 
        # pre-order, in-order, and post-order printing
        # with BST's
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
