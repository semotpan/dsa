package leetcode._1519;

import java.util.ArrayList;
import java.util.List;

public class NumberOfNodesTnTheSubTreeWithTheSameLabel {

    public int[] countSubTrees(int n, int[][] edges, String labels) {
        var G = new Graph(n, edges);
        var labelCounter = new DFSLabelCounter(G, labels);
        return labelCounter.counts();
    }
}

class Graph {
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

    public int V() {
        return V;
    }

    public boolean isLeaf(int v) {
        return adj[v].isEmpty();
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}

class DFSLabelCounter {

    private final Graph G;
    private final String labels;
    private final int[] frequency;
    private final int[] counts;

    DFSLabelCounter(Graph g, String labels) {
        this.G = g;
        this.labels = labels;
        this.frequency = new int[26];
        this.counts = new int[G.V()];
        dfs(-1, 0);
    }

    private void dfs(int parent, int v) {
        var prevState = frequency[labels.charAt(v) - 'a']++;

        if (G.isLeaf(v)) {
            return;
        }

        for (var w : G.adj(v)) {
            if (w == parent) {
                continue;
            }

            dfs(v, w);
        }
        counts[v] = frequency[labels.charAt(v) - 'a'] - prevState;
    }

    public int[] counts() {
        return counts;
    }
}
