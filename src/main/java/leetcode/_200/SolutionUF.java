package leetcode._200;

// 4ms
public class SolutionUF {
    public int numIslands(char[][] grid) {
        return new UnionFind(grid).count();
    }
}

class UnionFind {

    private final int[] id;
    private final int[] rank;
    private int count;

    public UnionFind(char[][] grid) {
        var N = grid.length;
        var M = grid[0].length;

        id = new int[N * M];
        rank = new int[N * M];

        for (var i = 0; i < N; i++) {
            for (var j = 0; j < M; j++) {
                if (grid[i][j] == '1') {
                    var p = i * M + j;
                    id[p] = p;
                    count++;

                    // try to connect prev component on x axe
                    var x = i - 1;
                    if (x >= 0 && grid[x][j] == '1') {
                        var q = x * M + j;
                        union(p, q);
                    }

                    // try to connect prev component on y axe
                    var y = j - 1;
                    if (y >= 0 && grid[i][y] == '1') {
                        var q = i * M + y;
                        union(p, q);
                    }
                }
            }
        }
    }

    // merges two components if the two sites are in different components,
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

    // method returns the number of components
    public int count() {
        return count;
    }

}
