package algo.uf;

public class UnionFind {
    private int[] id;
    private int[] size;

    public UnionFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        size = new int[n];
    }

    public boolean isConnected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {
        int rp = root(p);
        int rq = root(q);
        if (size[rp] >= size[rq]) {
            id[rq] = id[rp];
            size[rp] += size[rq];
        } else {
            id[rp] = id[rq];
            size[rq] += size[rp];
        }
    }

    private int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(10);
        uf.union(4, 3);
        uf.union(3, 8);
        uf.union(6, 5);
        uf.union(9, 4);
        uf.union(2, 1);
        uf.union(5, 0);
        uf.union(7, 2);
        uf.union(6, 1);
        uf.union(7, 3);
        System.out.println(uf.isConnected(3, 7));
        System.out.println(uf.isConnected(3, 8));
        System.out.println(uf.isConnected(3, 1));
    }
}
