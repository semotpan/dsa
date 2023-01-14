package leetcode._2246;

import java.util.ArrayList;
import java.util.List;

public class LongestPathWithDifferentAdjacentCharacters {

    public int longestPath(int[] parent, String s) {
        var G = new Graph(parent, s);
        var pathFinder = new PathFinder(G);
        return pathFinder.longestPath();
    }
}

class PathFinder {

    private final Graph G;
    private final boolean[] marked;
    private int longestPath;

    public PathFinder(Graph G) {
        this.G = G;
        this.longestPath = 1;
        this.marked = new boolean[G.V()];

        for (var v = 0; v < G.V(); ++v) {
            if (!marked[v]) {
                dfs(v);
            }
        }
    }

    private int dfs(int v) {
        marked[v] = true;

        if (G.isIsolated(v)) {
            return 1;
        }

        int maxPath = 0, secondMaxPath = 0;
        for (var w : G.adj(v)) {
            if (!marked[w]) {
                var childPathSize = dfs(w);

                if (childPathSize > maxPath) {
                    secondMaxPath = maxPath;
                    maxPath = childPathSize;
                    continue;
                }

                secondMaxPath = Integer.max(secondMaxPath, childPathSize);
            }
        }

        longestPath = Integer.max(longestPath, maxPath + secondMaxPath + 1);
        return maxPath + 1;
    }

    public int longestPath() {
        return longestPath;
    }
}

class Graph {

    private final int V;
    private final List<Integer>[] adj;

    Graph(int[] parent, String labels) {
        this.V = parent.length;
        this.adj = new List[this.V];

        for (var i = 0; i < V; ++i) {
            adj[i] = new ArrayList<>();
        }

        for (var i = 1; i < V; ++i) {
            if (labels.charAt(parent[i]) == labels.charAt(i)) continue;

            adj[i].add(parent[i]);
            adj[parent[i]].add(i);
        }
    }

    boolean isIsolated(int v) {
        return adj[v].isEmpty();
    }

    int V() {
        return V;
    }

    Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
