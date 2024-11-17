import java.util.*;
class Edge {
    int source, destination, weight;

    Edge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
}

class Graph {
    int V;
    List<List<Edge>> adjList;

    Graph(int V) {
        this.V = V;
        adjList = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adjList.add(new LinkedList<>());
        }
    }

    void addEdge(int source, int destination, int weight) {
        Edge edge = new Edge(source, destination, weight);
        adjList.get(source).add(edge);

        // For an undirected graph, you may want to add the reverse edge as well.
        // Edge reverseEdge = new Edge(destination, source, weight);
        // adjList.get(destination).add(reverseEdge);
    }

    void primMST() {
        boolean[] inMST = new boolean[V];
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        // Create a priority queue to store vertices with their key values
        PriorityQueue<Edge> pq = new PriorityQueue<>(V, Comparator.comparingInt(o -> o.weight));

        // Start with the first vertex
        key[0] = 0;
        pq.offer(new Edge(-1, 0, 0)); // Source vertex has no parent, so -1 is used as a placeholder

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int u = edge.destination;

            if (inMST[u]) {
                continue;
            }

            inMST[u] = true;

            for (Edge neighbor : adjList.get(u)) {
                int v = neighbor.destination;
                int weight = neighbor.weight;

                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    parent[v] = u;
                    pq.offer(new Edge(u, v, weight));
                }
            }
        }

        // Print the MST edges
        System.out.println("Minimum Spanning Tree (MST):");
        for (int i = 1; i < V; i++) {
            System.out.println("Edge: " + parent[i] + " - " + i + " Weight: " + key[i]);
        }
    }
}

public class PrimAlgorithm {
    public static void main(String[] args) {
        int V = 5;
        Graph graph = new Graph(V);

        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 6);
        graph.addEdge(1, 2, 3);
        graph.addEdge(1, 3, 8);
        graph.addEdge(1, 4, 5);
        graph.addEdge(2, 4, 7);
        graph.addEdge(3, 4, 9);

        graph.primMST();
    }
}

