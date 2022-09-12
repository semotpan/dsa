package leetcode._305;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/number-of-islands-ii/
public class SolutionUF {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        return new UnionFind(m, n, positions).countSnapshots();
    }
}

class UnionFind {

    private final int M;
    private final int N;
    private final int[] id;
    private final int[] rank;
    private final List<Integer> countSnapshots;
    private int count;

    public UnionFind(int m, int n, int[][] positions) {

        countSnapshots = new LinkedList<>();
        id = new int[n * m];
        rank = new int[n * m];
        M = m;
        N = n;

        Arrays.fill(id, -1);

        for (var position : positions) {
            var i = position[0];
            var j = position[1];
            var p = i * n + j;

            // skip if already processed
            if (id[p] != -1) {
                countSnapshots.add(count);
                continue;
            }

            id[p] = p;
            count++;

            tryUnion(i - 1, j, p); // try to connect prev component on x axe
            tryUnion(i + 1, j, p); // try to connect next component on x axe
            tryUnion(i, j - 1, p); // try to connect prev component on y axe
            tryUnion(i, j + 1, p); // try to connect next component on y axe

            countSnapshots.add(count);
        }
    }

    private void tryUnion(int x, int y, int p) {
        var q = x * N + y;
        if (x >= 0 && y >= 0 && x < M && y < N && id[q] != -1) {
            union(p, q);
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
    public List<Integer> countSnapshots() {
        return countSnapshots;
    }
}
