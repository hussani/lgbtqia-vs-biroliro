package  com.hussani.lgbtqia;

import com.hussani.lgbtqia.datastructure.AdjNode;
import com.hussani.lgbtqia.datastructure.GraphAdjList;
import com.hussani.lgbtqia.datastructure.MinHeap;
import com.hussani.lgbtqia.datastructure.MinHeapAdj;
import com.hussani.lgbtqia.datastructure.ShortestPath;

public class App {

    public static void main(String[] args) {
        GraphAdjList graph  = new GraphAdjList(5);
        graph.addEdge(0, 1, 9);
        graph.addEdge(0, 2, 6);
        graph.addEdge(0, 3, 5);
        graph.addEdge(0, 4, 3);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 4);

        ShortestPath shortestPath = new ShortestPath(graph);

        int source = 2;
        int[] distances = shortestPath.dijkstra(source);

        for (int i = 0; i < distances.length; i++) {
            System.out.println("Distance from " + source + " to " + i + " is " + distances[i]);
        }
    }
}
