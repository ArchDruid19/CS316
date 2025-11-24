package com.druid.PrimMST;

public class Main {
    public static void main(String[] args) {
        Integer[][] test_adj_matrix = {
                { null, 4, null, null, null, 8 },
                { 4, null, 7, null, null, 11 },
                { null, 7, null, 2, 3, null },
                { null, null, 2, null, 6, 7 },
                { null, null, 3, 6, null, 1 },
                { 8, 11, null, 7, 1, null }
        };

        MSTPrim(test_adj_matrix);

    }

    public static void MSTPrim(Integer[][] adj_matrix) {
        // Step 1. Create two arrays: one that tracks the nodes we have visted, and the other
        // to track the nodes we have yet to vist
        boolean[] visited_nodes = new boolean[adj_matrix.length];
        boolean[] unvisited_nodes = new boolean[adj_matrix.length];

        // Mark all nodes except the first as being unvisited
        for (int i = 1; i < unvisited_nodes.length; i++) {
            unvisited_nodes[i] = true; 
            System.out.println(unvisited_nodes[i]);
        }

        // Mark the first node as being visited
        visited_nodes[0] = true;

    }
}

/*
boolean[] visited_nodes = new boolean[adj_matrix.length];
        int prim_tree[] = new int[adj_matrix.length];

        // Mark the first node as visited (this is our starting node)
        visited_nodes[0] = true;
        // Put the first node in the tree
        prim_tree[0] = 0;
        for (int i = 0; i < 6; i++) {
            for (int row = 0; row < adj_matrix.length; row++) {
                //
                if (visited_nodes[row]) {
                    int min = Integer.MAX_VALUE;
                    int col_idx = -1;
                    for (int col = 0; col < adj_matrix.length; col++) {
                        if (adj_matrix[row][col] != null) {
                            // System.out.print(adj_matrix[row][col] + " ");
                            if (adj_matrix[row][col] < min && !visited_nodes[col]) {

                                min = adj_matrix[row][col];
                                col_idx = col;

                            }
                        }

                    }
                    System.out.println(min + " | " + col_idx);
                    // System.out.println(col_idx);
                    visited_nodes[col_idx] = true;
                }

            }
        }
*/
