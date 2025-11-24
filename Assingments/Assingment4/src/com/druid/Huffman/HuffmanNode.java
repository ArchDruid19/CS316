package com.druid.Huffman;

public class HuffmanNode implements Comparable<HuffmanNode> {
    HuffmanNode left = null;
    HuffmanNode right = null;
    int frequency;
    // This must be initated as null because merged nodes dont necessarily contain individual characters
    Character character = null;

    public HuffmanNode() {
        
    }

    public HuffmanNode(int frequency) {
        this.frequency = frequency;
    }

    public HuffmanNode(int frequency, Character character) {
        this.frequency = frequency;
        this.character = character;
    }

    // We must do this in order to use a minheap with the nodes, as the minheap would have
    // no idea what to compare on if we dont tell it to compare on frequency
    @Override
    public int compareTo(HuffmanNode arg0) {
        if (this.frequency < arg0.frequency) {
            return -1;
        } else if (this.frequency > arg0.frequency) {
            return 1;
        } else {
            return 0;
        }
    }
}
