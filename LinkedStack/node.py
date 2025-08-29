class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
        
    def printNodeInfo(self):
        print(self.data, end= " -> ")