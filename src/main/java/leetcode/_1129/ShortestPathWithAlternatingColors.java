package leetcode._1129;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ShortestPathWithAlternatingColors {

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        var G = new Digraph(n);

        for (var redEdge : redEdges)
            G.addRedEdge(redEdge[0], redEdge[1]);

        for (var blueEdge : blueEdges)
            G.addBlueEdge(blueEdge[0], blueEdge[1]);

        return new BFS(G).dist();
    }
}

class BFS {

    private final Digraph G;
    private final int[] dist;

    BFS(Digraph G) {
        this.G = G;
        this.dist = new int[G.V()];
        Arrays.fill(this.dist, -1);

        bsf();
    }

    private void bsf() {
        var marked = new boolean[G.V()][2];

        var q = new ArrayDeque<Edge>(G.adj(0));
        dist[0] = 0;

        var d = 1;
        while (!q.isEmpty()) {
            for (int i = 0, N = q.size(); i < N; ++i) {
                var edge = q.poll();

                if (dist[edge.w()] == -1) dist[edge.w()] = d;

                for (var nextEdge : G.adj(edge.w())) {
                    if (!marked[nextEdge.w()][nextEdge.color()] && edge.color() != nextEdge.color()) {
                        marked[nextEdge.w()][nextEdge.color()] = true;
                        q.add(nextEdge);
                    }
                }
            }

            ++d;
        }
    }

    int[] dist() {
        return dist;
    }
}

class Digraph {
    private final int V;
    private final List<Edge>[] adj;

    Digraph(int V) {
        this.V = V;
        this.adj = new List[V];

        for (int v = 0; v < V; ++v)
            this.adj[v] = new ArrayList<>();
    }

    void addBlueEdge(int v, int w) {
        adj[v].add(new Edge(v, w, 0));
    }

    void addRedEdge(int v, int w) {
        adj[v].add(new Edge(v, w, 1));
    }

    int V() {
        return V;
    }

    List<Edge> adj(int v) {
        return adj[v];
    }
}

record Edge(int v, int w, int color) {}
