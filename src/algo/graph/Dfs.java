package algo.graph;

import algo.graph.undirected.UndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class Dfs {
    private Graph g;

    public Dfs(Graph g) {
        this.g = g;
    }

    public List<Integer> anyPath(int s, int e) {
        boolean[] visited = new boolean[g.V()];
        List<Integer> path = new ArrayList<>();
        anyPath(s, e, path, visited);
        return path;
    }

    private boolean anyPath(int w, int e, List<Integer> path, boolean[] visited) {
        if (w == e) {
            path.add(w);
            return true;
        }

        if (visited[w]) {
            return false;
        }

        path.add(w);
        visited[w] = true;

        for (int v: g.adj(w)) {
            if (!visited[v]) {
                if (anyPath(v, e, path, visited)) {
                    return true;
                }
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    public List<List<Integer>> allPaths(int s, int e) {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[g.V()];
        allPaths(allPaths, path, visited, s, e);
        return allPaths;
    }

    private void allPaths(List<List<Integer>> allPaths, List<Integer> path, boolean[] visited, int w, int e) {
        if (w == e) {
            path.add(w);
            allPaths.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }

        if (visited[w]) {
            return;
        }

        path.add(w);
        visited[w] = true;

        for (int v: g.adj(w)) {
            if (!visited[v]) {
                allPaths(allPaths, path, visited, v, e);
            }
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        testUndirected();
        System.out.println();
        testDirected();
    }

    private static void testUndirected() {
        System.out.println("==============");
        System.out.println("Test undirected graph");

        UndirectedGraph g = new UndirectedGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);

        Dfs dfs = new Dfs(g);
        System.out.println("Any path: " + dfs.anyPath(0, 3));
        System.out.println("All paths: " + dfs.allPaths(0, 3));
    }

    private static void testDirected() {
        System.out.println("==============");
        System.out.println("Test directed graph");

        UndirectedGraph g = new UndirectedGraph(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 5);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 2);
        g.addEdge(3, 5);

        Dfs dfs = new Dfs(g);
        System.out.println("Any path: " + dfs.anyPath(0, 3));
        System.out.println("All paths: " + dfs.allPaths(0, 3));
    }

}
