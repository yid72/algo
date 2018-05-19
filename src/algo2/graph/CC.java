package algo2.graph;

/**
 * Connected components.
 */
public class CC {
    private final Graph g;

    private boolean[] visited;
    private int[] ids;
    private int count;

    public CC(Graph g) {
        this.g = g;
        this.visited = new boolean[g.V()];
        this.ids = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                count ++;
                dfs(i);
            }
        }
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return ids[v];
    }

    public boolean connected(int v, int w) {
        return ids[v] == ids[w];
    }

    private void dfs(int v) {
        visited[v] = true;
        ids[v] = count;
        for (int w : g.adj(v)) {
            if (!visited[w]) {
                dfs(w);
            }
        }
    }
}
