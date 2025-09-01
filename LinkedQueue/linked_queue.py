# For a queue, we are adding new items to the back
# and removing items from the front
# FIFO - First In First Out
# Keep track of two pointers - the head and the tail
# in order to keep O(1) time when pushing and popping

from node import Node

class LinkedQueue:
    def __init__(self):
        self.head = None
        self.tail = None

    def push(self, data):
        temp_node = Node(data)
        if self.head is None:
            self.head = temp_node
            self.tail = temp_node
        else:
            self.tail.next = temp_node
            self.tail = temp_node

    def pop(self):
        if self.head is None: # No values in list
            print("The list is empty!")
            return None
        if self.head is self.tail: # 1 value in list
            temp_node = self.head
            self.head = None
            self.tail = None
            return temp_node
        # more than 1 value in list


        return # finish this
    
    def isEmpty(self):
        return self.head == None
    
    def printListRecursive(self, head):
        # Base condition where either the list is empty
        # or head.next is empty in which case it exits out
        if head is None:
            return
        # Print the node, then call the method again
        # using the next node as a parameter
        head.printNodeInfo()
        self.printListRecursive(head.next)

    def printListIterative(self):
        temp_node = self.head
        while temp_node:
            temp_node.printNodeInfo()
            temp_node = temp_node.next
            

