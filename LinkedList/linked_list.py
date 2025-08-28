from node import Node
# from *filename* import *class*

class LinkList:
    def __init__(self):
        self.head = None

    def addFirst(self, value):
        temp_node = Node(value)
        if self.head is None:
            self.head = temp_node
        else:
            temp_node.next = self.head
            self.head = temp_node

    def removeFirst(self):
        temp_node = self.head
        if temp_node is not None:
            self.head = temp_node.next
            temp_node = None
        else:
            print("The list is empty!")

    def addLast(self, value):
        # Without keeping track of the tail of the list,
        # the time complexity is O(n) because the entire
        # list must be visited before the last is added.
        temp_node = Node(value)

        if self.head is None:
            self.head = temp_node
        else:
            temp_head_node = self.head

            while temp_head_node.next is not None:
                temp_head_node = temp_head_node.next

            temp_head_node.next = temp_node

    def removeLast(self):
        # First case: the list is empty
        if self.head is None:
            print("The list is empty!")
            return
        
        # Second case: the list has 1 element, which
        # means we clear the reference from head
        if self.head.next is None:
            self.head = None
            return
        
        temp_node = self.head

        # Must stop on the prev node from the tail
        # so we can clear the reference from the tail
        while temp_node.next.next is not None:
            temp_node = temp_node.next
        temp_node.next = None    
        
    
    # 'is' checks if two objects reference the same memory
    # location, which is good for checking singletons like
    # None
    def printList(self):
        temp_head_node = self.head
        while temp_head_node is not None:
            temp_head_node.displayNodeInfo()
            temp_head_node = temp_head_node.next
