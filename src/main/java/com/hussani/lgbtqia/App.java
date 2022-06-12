package  com.hussani.lgbtqia;

import com.hussani.lgbtqia.datastructure.GraphAdjList;
import com.hussani.lgbtqia.datastructure.ShortestPath;
import com.hussani.lgbtqia.datastructure.list.LinkedList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.out.println("Usage: java App <input-file>");
            System.exit(1);
        }
        long start = System.nanoTime();

        String filename = args[0];
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));

        int lineNumber = 0;
        int vertexCount = 0;
        int edgeCount = 0;
        int communityMemberCount = 0;
        int[] communityMember = null;
        int biroliro = -1;
        GraphAdjList graph = null;

        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] tokens = line.split(" ");
            if (lineNumber == 0) {
                vertexCount = Integer.parseInt(tokens[0]);
                edgeCount = Integer.parseInt(tokens[1]);
                communityMemberCount = Integer.parseInt(tokens[2]);
                communityMember = new int[communityMemberCount];
                graph  = new GraphAdjList(vertexCount);
            }

            if (lineNumber > 0 && lineNumber <= edgeCount) {
                graph.addEdge(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }

            if (lineNumber > edgeCount && lineNumber <= edgeCount + communityMemberCount) {
                communityMember[lineNumber - edgeCount - 1] = Integer.parseInt(tokens[0]);
            }

            if (lineNumber > edgeCount + communityMemberCount) {
                biroliro = Integer.parseInt(tokens[0]);
            }
            lineNumber++;
        }

        long initialization = System.nanoTime();

        ShortestPath shortestPath = new ShortestPath(graph);

        int[][] distanceMatrix = new int[communityMemberCount+1][vertexCount];

        distanceMatrix[0] = shortestPath.dijkstra(biroliro);;
        for (int i = 1; i <= communityMemberCount; i++) {
            distanceMatrix[i] = shortestPath.dijkstra(communityMember[i -1]);
        }

        LinkedList<Integer> cities = getSafeCities(distanceMatrix);

        if (cities.isEmpty()) {
            System.out.println("INFELIZMENTE O PRECONCEITO VENCEU :(");
        } else {
            System.out.println("O REINO ESTÁ SALVO!");
            cities.print();
        }

        long end = System.nanoTime();

        if (args.length >= 2 && args[1].equals("-v")) {
            System.out.println("Initialization time: " + (initialization - start) / 1000000 + " ms");
            System.out.println("Execution time: " + (end - initialization) / 1000000 + " ms");
            System.out.println("Total time: " + (end - start) / 1000000 + " ms");
        }
    }

    private static LinkedList<Integer> getSafeCities(int[][] distanceMatrix) {
        LinkedList<Integer> cities = new LinkedList<>();

        for (int j = 0; j < distanceMatrix[0].length; j++) {
            int limit = distanceMatrix[0][j];
            int max = 0;
            for (int i = 1; i < distanceMatrix.length; i++) {
                if (distanceMatrix[i][j] > max) {
                    max = distanceMatrix[i][j];
                }
            }
            if (max < limit) {
                cities.add(j);
            }
        }
        return cities;
    }
}
