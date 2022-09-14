package dsa.graphs;

/**
 * Depth First Search algorithm on Graph based on Adjacency-list
 * count() - number of reached vertices
 */
public final class DepthFirstSearch {

    private final boolean[] marked;
    private int count;

    public DepthFirstSearch(Graph G, int source) {
        this.marked = new boolean[G.V()];
        dfs(G, source);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count++;

        for (var w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public int count() {
        return count;
    }
}
