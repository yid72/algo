package algo1.unionfind;

public class QuickUnion implements UnionFind {
    private int[] ids;

    public QuickUnion(int N) {
        ids = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
        }
    }

    public void union(int p, int q) {
        final int i = root(p);
        final int j = root(q);
        ids[i] = ids[j];
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    private int root(int p) {
        while (ids[p] != p) {
            p = ids[p];
        }
        return p;
    }
}
