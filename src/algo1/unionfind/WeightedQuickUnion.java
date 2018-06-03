package algo1.unionfind;

public class WeightedQuickUnion {
    private int[] ids;
    private int[] sizes;

    public WeightedQuickUnion(int N) {
        ids = new int[N];
        sizes = new int[N];
        for (int i = 0; i < N; i++) {
            ids[i] = i;
            sizes[i] = 1;
        }
    }

    public void union(int p, int q) {
        final int i = root(p);
        final int j = root(q);
        if (sizes[i] <= sizes[j]) {
            ids[i] = j;
            sizes[j] += sizes[i];
        }
        else {
            ids[j] = i;
            sizes[i] += sizes[j];
        }
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
