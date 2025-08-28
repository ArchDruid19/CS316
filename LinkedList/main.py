from linked_list import LinkList

# Singly linked list
# Strong inspiration taken from CS216 Lab 11
# https://github.com/ArchDruid19/CS216-Code/tree/main/Lab%2011%20-%20LinkedList%20Update%20Operations
def main():
    testlist = LinkList()
    testlist.addFirst(1)
    testlist.addFirst(2)
    testlist.addFirst(10)
    testlist.addLast(-19)
    #testlist.printList()
    testlist.removeLast()
    testlist.printList()

if __name__ == "__main__":
    main()    
