package com.hussani.lgbtqia.datastructure;

public class GraphAdjList {

    final AdjNode[] graph;

    public GraphAdjList(AdjNode[] graph) {
        this.graph = graph;
    }

    public GraphAdjList(final int numberOfVertices) {
        this.graph = new AdjNode[numberOfVertices];
    }

    public void addEdge(int source, int destination, int weight) {
        if (graph[source] == null) {
            graph[source] = new AdjNode(destination, weight);
            return;
        }

        AdjNode firstNode = graph[source];
        graph[source] = new AdjNode(destination, weight, firstNode);
    }

    public AdjNode getAdjacentVertex(int vertex) {
        return graph[vertex];
    }
}
