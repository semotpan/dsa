package dsa.fundamentals;

// classic algo
public final class UnionFind {

    private final int[] id;
    private int count;

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++)
            id[i] = i;

    }

    //merges two components if the two sites are in different components,
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        
        // Nothing to do if p and q are already in the same component.
        if (pID == qID)
            return;
        // Rename p’s component to q’s name.
        for (int i = 0; i < id.length; i++)
            if (id[i] == pID)
                id[i] = qID;
        count--;
    }

    //operation returns an integer component identifier for a given site
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    //operation determines whether two sites are in the same component
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // method returns the number of components
    int count() {
        return count;
    }
}
