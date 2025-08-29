class Node:
    def __init__(self, value):
        self.value = value
        self.next = None  


def main():
    node1 = Node(1)
    node2 = Node(2)
    node3 = Node(3)
    node4 = Node(4)

    node1.next = node2
    node2.next = node3
    node3.next = node4

    temp = node1
    while temp: # This is true until a null next pointer is reached
        print(temp.value, end=" -> ")
        temp = temp.next

if __name__ == "__main__":
    main()    
