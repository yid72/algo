package algo.graph.weighted;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {
    private final WeightedGraph graph;

    public Dijkstra(int n, int[][] edges) {
        graph = new WeightedGraph(n);
        for (int[] edge: edges) {
            graph.addEdge(edge[0], edge[1], edge[2]);
        }
    }

    public List<Integer> shortestPath(int start, int end) {
        int[] path = new int[graph.V()];
        Arrays.fill(path, -1);

        int[] distances = new int[graph.V()];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        queue.offer(new int[] {start, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int from = curr[0];
            int dist = curr[1];
            if (from == end) {
                break;
            }

            for (WeightedEdge edge: graph.getEdges(from)) {
                int to = edge.getTo();
                int toDist = dist + edge.getWeight();
                System.out.printf("from %d to %d. newDist: %d. dist: %d\n", from, to, toDist, distances[to]);
                if (toDist < distances[to]) {
                    distances[to] = toDist;
                    path[to] = from;
                    queue.offer(new int[] {to, toDist});
                }
            }
        }

        if (path[end] == -1) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        while (end != start) {
            res.add(end);
            end = path[end];
        }
        res.add(start);
        Collections.reverse(res);
        return res;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{0, 1, 7}, {0, 4, 1}, {1, 2, 3}, {1, 4, 8},
                {2, 3, 6}, {2, 4, 2}, {3, 4, 7}};
        Dijkstra dijk = new Dijkstra(5, edges);
        System.out.println(dijk.shortestPath(0, 2));
    }
}
