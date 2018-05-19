package algo2.graph;

import java.util.LinkedList;
import java.util.Queue;

public class Bfs extends AbstractPaths {
    private final Graph g;
    private final int s;
    private boolean[] marked;

    public Bfs(Graph g, int s) {
        super(g, s);

        this.g = g;
        this.s = s;
        this.marked = new boolean[g.V()];

        bfs(s);
    }

    private void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        marked[v] = true;
        addEdge(v, v);
        queue.add(v);
        while (!queue.isEmpty()) {
            v = queue.remove();
            for (int w : g.adj(v)) {
                if (!marked[w]) {
                    marked[w] = true;
                    addEdge(v, w);
                    queue.add(w);
                }
            }
        }
    }
}
