class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
    def printNodeInfo(self):
        if self.next is not None:
            print(self.data, end = " -> ")
        else:
            print(self.data, end = "")
