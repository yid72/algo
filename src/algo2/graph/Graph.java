package algo2.graph;

import java.util.HashSet;
import java.util.Set;

public class Graph {
    private final int V;
    private int E;
    private final Set<Integer>[] adj;

    public Graph(int V) {
        this.V = V;

        adj = new Set[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<>();
        }
    }

    public void addEdge(int v, int w) {
        if (adj[v].contains(w)) {
            return;
        }

        adj[v].add(w);
        adj[w].add(v);
        E ++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
