package com.hussani.lgbtqia.datastructure;

import java.util.Arrays;

public class ShortestPath {

    private final GraphAdjList graph;

    public ShortestPath(GraphAdjList graph) {
        this.graph = graph;
    }

    public int[] dijkstra(int source) {
        final int[] distance = new int[graph.getNumberOfVertices()];
        final boolean[] visited = new boolean[graph.getNumberOfVertices()];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;

        MinHeapAdj heap = new MinHeapAdj(graph.getNumberOfVertices());
        heap.add(new AdjNode(source, 0));

        int visitedCount = 0;
        while (heap.getSize() > 0 && visitedCount < graph.getNumberOfVertices()) {
            AdjNode min = heap.extractMin();

            if (visited[min.getVertex()]) {
                continue;
            }

            visited[min.getVertex()] = true;
            visitedCount++;

            int vertex = min.getVertex();
            int weight = min.getWeight();
            AdjNode adjacent = graph.getAdjacentVertex(vertex);
            while (adjacent != null) {
                int adjacentVertex = adjacent.getVertex();

                if (visited[adjacentVertex]) {
                    adjacent = adjacent.getNext();
                    continue;
                }
                int adjacentWeight = adjacent.getWeight();
                if (distance[adjacentVertex] > distance[vertex] + adjacentWeight) {
                    distance[adjacentVertex] = distance[vertex] + adjacentWeight;
                    heap.add(new AdjNode(adjacentVertex, distance[adjacentVertex]));
                }
                adjacent = adjacent.getNext();
            }
        }

        return distance;
    }
}
