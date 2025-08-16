package algo.graph.weighted;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
    private final int V;
    private final List<WeightedEdge>[] edges;

    public WeightedGraph(int V) {
        this.V = V;

        edges = new List[V];
        for (int i = 0; i < V; i++) {
            edges[i] = new ArrayList<>();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(int from, int to, int weight) {
        edges[from].add(new WeightedEdge(from, to, weight));
        edges[to].add(new WeightedEdge(to, from, weight));
    }

    public List<WeightedEdge> getEdges(int from) {
        return edges[from];
    }
}
