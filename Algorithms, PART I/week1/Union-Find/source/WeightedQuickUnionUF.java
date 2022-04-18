public class WeightedQuickUnionUF {

    private int[] id;
    private int[] sz;

    /* set id of each abject to itself (N array accesses) */
    public WeightedQuickUnionUF(int N) {
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        for (int i = 0; i < N; i++)
            sz[i] = 1;
    }

    /* chase parent pointers until reach root (depth of p and q array accesses) */
    private int root(int i) {
        while (i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    /* check if p and q have same root (depth of p and q array accesses) */
    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    /*
     * change root of p and q to point to root of q (depth of p and q array
     * accesses)
     */
    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
    }
}
