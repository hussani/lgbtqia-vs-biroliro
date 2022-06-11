package  com.hussani.lgbtqia;

import com.hussani.lgbtqia.datastructure.AdjNode;
import com.hussani.lgbtqia.datastructure.GraphAdjList;
import com.hussani.lgbtqia.datastructure.MinHeap;
import com.hussani.lgbtqia.datastructure.MinHeapAdj;

public class App {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        int[] keys = new int[] {12, 11, 13, 5, 6, 7};
        MinHeap minHeap = new MinHeap(keys);

        GraphAdjList graph  = new GraphAdjList(7);
        graph.addEdge(0, 1, 5);
        graph.addEdge(0, 4, 9);
        graph.addEdge(1, 2, 12);
        graph.addEdge(1, 3, 15);
        graph.addEdge(1, 4, 4);
        graph.addEdge(2, 3, 3);
        graph.addEdge(2, 4, 11);
        graph.addEdge(3, 4, 11);

        AdjNode[] adjNodes = new AdjNode[] {
                new AdjNode(2, 12),
                new AdjNode(1, 5),
                new AdjNode(4, 9),
                new AdjNode(4, 11),
                new AdjNode(4, 4),
                new AdjNode(3, 15),
                new AdjNode(4, 11),
                new AdjNode(3, 3),
        };

        MinHeapAdj minHeapAdj = new MinHeapAdj(adjNodes);

        System.out.println("MinHeap: " + minHeapAdj.extractMin());
        System.out.println("MinHeap: " + minHeapAdj.extractMin());
        System.out.println("MinHeap: " + minHeapAdj.extractMin());
        System.out.println("MinHeap: " + minHeapAdj.extractMin());
        System.out.println("MinHeap: " + minHeapAdj.extractMin());
        System.out.println("MinHeap: " + minHeapAdj.extractMin());
        System.out.println("MinHeap: " + minHeapAdj.extractMin());
    }
}
