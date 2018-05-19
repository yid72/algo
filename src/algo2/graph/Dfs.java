package algo2.graph;

public class Dfs extends AbstractPaths {
    private final Graph g;
    private final int s;

    private boolean[] marked;

    public Dfs(Graph g, int s) {
        super(g, s);
        this.g = g;
        this.s = s;
        this.marked = new boolean[g.V()];

        dfs(s);
    }

    private void dfs(int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                addEdge(v, w);
                dfs(w);
            }
        }
    }
}
