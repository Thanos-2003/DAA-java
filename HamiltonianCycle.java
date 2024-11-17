

public class HamiltonianCycle {

    public static boolean isSafe(int v, int pos, int[] path, int[][] graph) {
        if (graph[path[pos - 1]][v] == 0)
            return false;

        for (int i = 0; i < pos; i++)
            if (path[i] == v)
                return false;

        return true;
    }

    public static boolean hamiltonianCycleUtil(int[][] graph, int[] path, int pos) {
        int V = graph.length;

        if (pos == V) {
            if (graph[path[pos - 1]][path[0]] == 1)
                return true;
            else
                return false;
        }

        for (int v = 1; v < V; v++) {
            if (isSafe(v, pos, path, graph)) {
                path[pos] = v;

                if (hamiltonianCycleUtil(graph, path, pos + 1))
                    return true;

                path[pos] = -1;
            }
        }

        return false;
    }

    public static boolean hamiltonianCycle(int[][] graph) {
        int V = graph.length;
        int[] path = new int[V];
        for (int i = 0; i < V; i++)
            path[i] = -1;

        path[0] = 0;

        if (!hamiltonianCycleUtil(graph, path, 1)) {
            System.out.println("No Hamiltonian cycle exists.");
            return false;
        }

        System.out.println("Hamiltonian cycle exists: ");
        for (int i = 0; i < V; i++)
            System.out.print(path[i] + " ");

        System.out.println(path[0]);
        return true;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 1, 0, 1, 0},
                {1, 0, 1, 1, 1},
                {0, 1, 0, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 1, 1, 1, 0}
        };

        hamiltonianCycle(graph);
    }
}

