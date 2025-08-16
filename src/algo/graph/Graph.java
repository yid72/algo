package algo.graph;

import java.util.Set;

public interface Graph {
    int V();

    void addEdge(int w, int v);

    Set<Integer> adj(int w);
}
