package algo1.unionfind;

public class QuickFind implements UnionFind {
    private int[] ids;

    public QuickFind(int N) {
        ids = new int[N];
        for (int i = 0;  i < N; i++) {
            ids[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        for (int i = 0; i < ids.length; i ++) {
            if (ids[i] == p) {
                ids[i] = q;
            }
        }
    }

    @Override
    public boolean connected(int p, int q) {
        return ids[p] == ids[q];
    }
}
