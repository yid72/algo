package algo.graph;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractGraph implements Graph {
    private final int V;
    protected Set<Integer>[] adj;

    public AbstractGraph(int V) {
        this.V = V;

        adj = new Set[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new HashSet<>();
        }
    }

    @Override
    public int V() {
        return V;
    }

    public abstract void addEdge(int w, int v);

    @Override
    public Set<Integer> adj(int w) {
        return adj[w];
    }
}
