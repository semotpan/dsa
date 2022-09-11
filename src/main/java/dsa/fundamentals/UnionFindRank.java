package dsa.fundamentals;

public final class UnionFindRank {

    private final int[] id;
    private final int[] rank; // rank represent number of elements in a components
    private int count; // number of components

    public UnionFindRank(int N) {
        id = new int[N];
        rank = new int[N];
        count = N;

        // init classic approach
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    // merges two components if the two sites are in different com- ponents,
    // using rank to rename component
    public void union(int p, int q) {
        int pID = find(p);
        int qID = find(q);

        // Nothing to do if p and q are already
        // in the same component.
        if (pID == qID)
            return;

        // Rename component to the highest rank's name between components.
        if (rank[pID] > rank[qID]) {
            id[qID] = pID;
        } else if (rank[pID] < rank[qID]) {
            id[pID] = qID;
        } else {
            id[qID] = pID;
            rank[pID] += 1;
        }
        --count;
    }

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
    public int count() {
        return count;
    }
}
