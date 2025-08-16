package algo.graph.undirected;

import algo.graph.AbstractGraph;

public class UndirectedGraph extends AbstractGraph {
    public UndirectedGraph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int w, int v) {
        adj[w].add(v);
        adj[v].add(w);
    }
}
