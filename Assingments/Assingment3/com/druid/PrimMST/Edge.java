package com.druid.PrimMST;

public class Edge {
    int current_vertex;
    int ending_vertex;
    int weight;

    public Edge(int current_vertex, int ending_vertex, int weight) {
        this.current_vertex = current_vertex;
        this.ending_vertex = ending_vertex;
        this.weight = weight;
    }
}
