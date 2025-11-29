# To create Huffman nodes
from huffman_node import HuffmanNode

# To create a min-heap for the Huffman nodes
import heapq


def createLetterOccurenceDict(string_a):
    # We are only worrying about lowercase letters
    string_a = string_a.lower()
    # Step 1.
    # Create a dictionary that will hold character as keys and letter occurences as values
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

    return letter_occurence_dictionary


def createHuffmanTree(letter_occurence_dictionary):
    huffman_min_heap = []
    for items in letter_occurence_dictionary:
        # Step 3.
        # Create huffman leaf nodes that contain a frequency and character, with the left and right set to none
        temp_node = HuffmanNode(letter_occurence_dictionary[items], items, None, None)

        # Push the new node into a min-heap so we can later create the tree
        heapq.heappush(huffman_min_heap, temp_node)

    # Step 4.
    # Pop out nodes two at a time and combine them with a parent node and then add that parent node back into
    # the min-heap
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

    # The last node in the min-heap will be the root of the entire huffman tree
    huffman_tree_root_node = heapq.heappop(huffman_min_heap)

    # Return the root of the huffman tree
    return huffman_tree_root_node


def traverseLRV(huffman_root_node, variable_bit_codes_dict, string_result):
    # Step 5.
    # construct a dictionary of variable bit length codes using the standard post-order recursive method to traverse
    # a binary tree (post order finds the leaf nodes of a subtree first)
    if huffman_root_node is None:
        return
    # If both the left and right node are nothing, then we MUST be at a leaf node (character node)
    # In this case, we add the character as the key of the dictionary, and the string_result (variable bit code) as the value
    if huffman_root_node.left is None and huffman_root_node.right is None:
        variable_bit_codes_dict[huffman_root_node.character] = string_result

    traverseLRV(huffman_root_node.left, variable_bit_codes_dict, string_result + "0")
    traverseLRV(huffman_root_node.right, variable_bit_codes_dict, string_result + "1")


def calculateHuffmanCompression(count_dict, variable_bit_codes_dict, string_a):
    # Step 6.
    # Find how much we compressed the string by taking the compressed size of the string and dividing it by the original size

    # Each ASCII character is 8 bits, so multiply the length of the string by 8 to get the original size
    original_size = len(string_a) * 8

    # We will convert the values of the count dictionary and the variable length bit codes to a list for easier processing in a loop
    count_dict_values = list(count_dict.values())
    variable_bit_codes_dict_values = list(variable_bit_codes_dict.values())

    compressed_size = 0

    # Multiply the lengths of the variable bit codes by the number of times they appear in the string to
    # get the total number of compressed bits (if a letter appears 3 times and has a code length of 2, then that letter uses 6 total bits; etc...)
    for i in range(len(count_dict_values)):
        compressed_size += count_dict_values[i] * len(variable_bit_codes_dict_values[i])

    compression_ratio = compressed_size / original_size
    # Print the original and compressed sizes using string formatting
    print(
        "Original size: %.4f bits\nCompressed size: %.4f bits"
        % (original_size, compressed_size)
    )
    print("Total compressed size: %.4f/%.4f" % (compressed_size, original_size))
    print("The string has been compressed with a ratio of: %.4f" % (compression_ratio))
    return compression_ratio


def performHuffmanEncoding(string_a):
    count_dict = createLetterOccurenceDict(string_a)
    huffman_root_node = createHuffmanTree(count_dict)
    variable_bit_codes_dict = {}
    traverseLRV(huffman_root_node, variable_bit_codes_dict, "")
    compressed_size = calculateHuffmanCompression(
        count_dict, variable_bit_codes_dict, string_a
    )

    # Return the code dictionary as the end user will need this to decode the messege
    return variable_bit_codes_dict


def main():
    performHuffmanEncoding("saginaw")


if __name__ == "__main__":
    main()
