package leetcode._1443;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {

    private List<Boolean> hasApple;
    private List<Integer>[] adj;

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        this.hasApple = hasApple;
        this.adj = new List[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>(20);
        }

        for (int[] edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }

        return dfs(-1, 0);
    }

    private int dfs(int parent, int v) {
        if (adj[v].isEmpty()) {
            return 0;
        }

        int total = 0;
        for (var w : adj[v]) {
            if (w == parent) {
                continue;
            }

            var childTime = dfs(v, w);

            if (childTime > 0 || hasApple.get(w)) {
                total += childTime + 2;
            }
        }

        return total;
    }
}
