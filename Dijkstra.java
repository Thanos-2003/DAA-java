import java.util.*;

public class Dijkstra{
    private static final int INF = Integer.MAX_VALUE; // Represents infinity

    public static void dijkstra(int[][] graph, int source) {
        int numVertices = graph.length;
        int[] distance = new int[numVertices]; // Stores the shortest distance from source to each vertex
        boolean[] visited = new boolean[numVertices]; // Keeps track of visited vertices

        // Initialize distance array with infinity and visited array with false
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        // The distance from the source vertex to itself is 0
        distance[source] = 0;

        for (int i = 0; i < numVertices - 1; i++) {
            int minDistance = findMinDistance(distance, visited);
            visited[minDistance] = true;

            for (int v = 0; v < numVertices; v++) {
                if (!visited[v] && graph[minDistance][v] != 0 &&
                        distance[minDistance] != INF &&
                        distance[minDistance] + graph[minDistance][v] < distance[v]) {
                    distance[v] = distance[minDistance] + graph[minDistance][v];
                }
            }
        }

        // Print the shortest distances from the source vertex
        System.out.println("Shortest distances from source vertex " + (source+1) + ":");
        for (int i = 0; i < numVertices; i++) {
            System.out.println("Vertex " + (i+1) + ": " + distance[i]);
        }
    }

    private static int findMinDistance(int[] distance, boolean[] visited) {
        int minDistance = INF;
        int minIndex = -1;
        int numVertices = distance.length;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && distance[v] <= minDistance) {
                minDistance = distance[v];
                minIndex = v;
            }
        }

        return minIndex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0,3,0,7,0},
                {3,0,4,2,0},
                {0,4,0,5,6},
                {7,2,5,0,4},
                {0,0,6,4,0},
        };

        int sourceVertex = 0;
        dijkstra(graph, sourceVertex);
    }
}

