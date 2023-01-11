package leetcode._1443;

import java.util.ArrayList;
import java.util.List;

public class MinimumTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        var G = new Graph(n, edges);
        var dfsFinder = new DFSFinder(G, hasApple);
        return dfsFinder.minTimes();
    }
}

final class Graph {
    private final int V;
    private final List<Integer>[] adj;

    public Graph(int v, int[][] edges) {
        this.V = v;
        adj = new List[v];

        for (var i = 0; i < V; i++) {
            adj[i] = new ArrayList<>();
        }

        for (var edge : edges) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
    }

    public boolean isLeaf(int v) {
        return adj[v].isEmpty();
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

final class DFSFinder {

    private final Graph G;
    private final List<Boolean> hasApple;
    private final int minTimes;

    public DFSFinder(Graph G, List<Boolean> hasApple) {
        this.G = G;
        this.hasApple = hasApple;
        this.minTimes = dfs(-1, 0);
    }

    private int dfs(int parent, int v) {
        if (G.isLeaf(v)) {
            return 0;
        }

        var totalTimes = 0;
        for (var w : G.adj(v)) {
            if (w == parent) {
                continue;
            }

            var childTime = dfs(v, w);

            if (hasApple.get(w) || childTime > 0) {
                totalTimes += childTime + 2;
            }
        }

        return totalTimes;
    }

    public int minTimes() {
        return minTimes;
    }
}
