# To create Huffman nodes
from huffman_node import HuffmanNode

# To create a min-heap for the Huffman nodes
import heapq


def createLetterOccurenceDict(string_a):
    # We are only worrying about lowercase letters
    string_a = string_a.lower()
    # Step 1.
    # Create a dictionary that will hold character: letter occurences
    # dictionaries dont allow duplicate keys so when we count letters we can keep updating the key values with any new # of letter occurce we find
    letter_occurence_dictionary = {}

    # Step 2
    # Count the numbers of letters in the string by comparing each letter to all letters in the string and if it is a match, add 1
    for i in range(len(string_a)):
        letter_occurence = 0
        for j in range(len(string_a)):
            if string_a[i] == string_a[j]:
                letter_occurence += 1
        letter_occurence_dictionary[string_a[i]] = letter_occurence
    print(letter_occurence_dictionary)

    return letter_occurence_dictionary


def createHuffmanTree(letter_occurence_dictionary):
    huffman_min_heap = []
    for items in letter_occurence_dictionary:
        # Step 3.
        # Create a huffman leaf node that contains a frequency and character, with the left and right set to none
        temp_node = HuffmanNode(letter_occurence_dictionary[items], items, None, None)

        # Push the new node into a min-heap so we can later create the tree
        heapq.heappush(huffman_min_heap, temp_node)

    while len(huffman_min_heap) != 1:
        # Pop out a left node from the heap
        left_node = heapq.heappop(huffman_min_heap)
        # Pop out a right node from the heap
        right_node = heapq.heappop(huffman_min_heap)

        # Create a parent node whos frequency is the left + right
        # The parent should have no character, and will have the left as the left_node and right as the right_node
        parent_node = HuffmanNode(
            left_node.frequency + right_node.frequency, None, None, None
        )
        parent_node.left = left_node
        parent_node.right = right_node

        # Push the newly created parent node back into the heap until there is only 1 node left which is the root node
        # From Huffman Encoding powerpoint pg. 13
        heapq.heappush(huffman_min_heap, parent_node)

    huffman_tree_root_node = heapq.heappop(huffman_min_heap)

    return huffman_tree_root_node


def traverseLRV(huffman_root_node):
    if huffman_root_node is None:
        return
    traverseLRV(huffman_root_node.left)
    traverseLRV(huffman_root_node.right)
    print(huffman_root_node.frequency, huffman_root_node.character)


def main():
    dict = createLetterOccurenceDict("banana bandana")
    huffman_root_node = createHuffmanTree(dict)
    traverseLRV(huffman_root_node)


if __name__ == "__main__":
    main()
