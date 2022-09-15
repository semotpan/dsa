package dsa.graphs;

import java.util.ArrayDeque;

public final class DepthFirstPaths {

    private final boolean[] marked;
    private final int[] edgeTo;
    private final int source;

    public DepthFirstPaths(Graph G, int source) {
        this.source = source;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];

        dfs(G, source);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;

        for (var w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // build first path to the given node (!!not the shortest)
    public Iterable<Integer> pathTo(int v) {

        if (!hasPathTo(v)) {
            return null;
        }

        var path = new ArrayDeque<Integer>();
        for (var x = v; x != source; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(source);

        return path;
    }
}
