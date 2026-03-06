import java.util.*;

public class MaxFlow {

    static int bfs(int[][] capacity, int source, int sink, int[] parent) {

        int n = capacity.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);

        visited[source] = true;
        parent[source] = -1;

        while (!queue.isEmpty()) {

            int u = queue.poll();

            for (int v = 0; v < n; v++) {

                if (!visited[v] && capacity[u][v] > 0) {

                    queue.add(v);
                    parent[v] = u;
                    visited[v] = true;

                    if (v == sink)
                        return 1;
                }
            }
        }

        return 0;
    }

    static int edmondsKarp(int[][] capacity, int source, int sink) {

        int n = capacity.length;
        int[] parent = new int[n];

        int maxFlow = 0;

        while (bfs(capacity, source, sink, parent) == 1) {

            int pathFlow = Integer.MAX_VALUE;

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                pathFlow = Math.min(pathFlow, capacity[u][v]);
            }

            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                capacity[u][v] -= pathFlow;
                capacity[v][u] += pathFlow;
            }

            maxFlow += pathFlow;
        }

        return maxFlow;
    }

    public static void main(String[] args) {

        int[][] capacity = {
                {0,10,5,0,0},
                {0,0,15,10,0},
                {0,0,0,10,5},
                {0,0,0,0,10},
                {0,0,0,0,0}
        };

        int source = 0;
        int sink = 4;

        System.out.println("Maximum trucks per hour: "
                + edmondsKarp(capacity, source, sink));
    }
}