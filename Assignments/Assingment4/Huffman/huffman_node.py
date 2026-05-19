class HuffmanNode:
    def __init__(self, frequency, character, left, right):
        self.frequency = frequency
        self.character = character
        self.left = None
        self.right = None

    # We need this so the min_heap knows that we are comparing on frequencies
    def __lt__(self, other_node):
        return self.frequency < other_node.frequency
