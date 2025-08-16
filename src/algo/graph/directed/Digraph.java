package algo.graph.directed;

import algo.graph.AbstractGraph;

public class Digraph extends AbstractGraph {
    public Digraph(int V) {
        super(V);
    }

    @Override
    public void addEdge(int w, int v) {
        adj[w].add(v);
    }
}
