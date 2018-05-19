package algo2.graph;

import edu.princeton.cs.algs4.Stack;

public class Dfs implements Paths {
    private final Graph g;
    private final int s;

    private boolean[] marked;
    private int[] edgeTo;

    public Dfs(Graph g, int s) {
        this.g = g;
        this.s = s;
        this.marked = new boolean[g.V()];
        this.edgeTo = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            this.edgeTo[i] = -1;
        }

        dfs(s);
    }

    @Override
    public boolean hasPathTo(int v) {
        return edgeTo[v] > -1;
    }

    @Override
    public Iterable<Integer> pathTo(int v) {
        final Stack<Integer> stack = new Stack<>();
        if (!hasPathTo(v)) {
            return stack;
        }

        for (int w = edgeTo[v]; w != s; w = edgeTo[w]) {
            stack.push(w);
        }
        stack.push(s);
        return stack;
    }

    private void dfs(int v) {
        marked[v] = true;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(w);
            }
        }
    }
}
