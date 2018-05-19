package algo2.graph;

import edu.princeton.cs.algs4.Stack;

public abstract class AbstractPaths implements Paths {
    private final int s;
    private final int[] edgeTo;

    public AbstractPaths(Graph g, int s) {
        this.s = s;

        edgeTo = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            edgeTo[i] = -1;
        }
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

    protected void addEdge(int v, int w) {
        edgeTo[w] = v;
    }
}
