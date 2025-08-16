package algo.graph;

import algo.graph.directed.Digraph;
import algo.graph.undirected.UndirectedGraph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bfs {
    private Graph g;

    public Bfs(Graph g) {
        this.g = g;
    }

    public List<Integer> shortestPath(int start, int end) {
        int[] parents = new int[g.V()];
        for (int i = 0; i < parents.length; i++) {
            parents[i] = -1;
        }

        boolean[] visited = new boolean[g.V()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        while (!queue.isEmpty()) {
            int w = queue.poll();
            if (w == end) {
                break;
            }

            for (int v: g.adj(w)) {
                if (!visited[v]) {
                    parents[v] = w;
                    queue.offer(v);
                    visited[v] = true;
                }
            }
        }

        Deque<Integer> path = new LinkedList<>();
        path.add(end);
        while (parents[end] != -1) {
            path.addFirst(parents[end]);
            end = parents[end];
        }
        return new ArrayList<>(path);
    }

    public List<List<Integer>> allPaths() {
        return null;
    }

    public static void main(String[] args) {
        System.out.println("-------------");
        System.out.println("Test undirected graph...");
        testUndirectedGraph();

        System.out.println();
        System.out.println("-------------");
        System.out.println("Test directed graph...");
        testDirectedGraph();
    }

    private static void testUndirectedGraph() {
        UndirectedGraph g = new UndirectedGraph(4);
        g.addEdge(0 ,1);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);

        Bfs bfs = new Bfs(g);
        System.out.println("Shortest path: " + bfs.shortestPath(0, 3));
    }

    private static void testDirectedGraph() {
        System.out.println("Test Directed Graph...");

        Digraph g = new Digraph(4);
        g.addEdge(0 ,1);
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        Bfs bfs = new Bfs(g);
        System.out.println("Shortest path: " + bfs.shortestPath(0, 3));
    }

}
