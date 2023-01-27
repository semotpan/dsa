package leetcode._787;

import dsa.sorting.IndexMinPQ;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class CheapestFlightsWithinKStops {

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        return new BellmanFord(flights, n, src, dst, k).dist();
    }
}

class BellmanFord {

    private final int dst;
    private final int[] dist;

    BellmanFord(int[][] edges, int V, int source, int dst, int k) {
        this.dst = dst;
        dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        for (int i = 0; i <= k; i++) {
            var temp = Arrays.copyOf(dist, V);
            var reached = false;
            for (var edge : edges) {
                int src = edge[0], dest = edge[1], cost = edge[2];
                if (temp[src] < Integer.MAX_VALUE && dist[dest] > (dist[src] + cost)) {
                    dist[dest] = temp[src] + cost;
                    reached = true;
                }
            }
            if (!reached) break;
        }
    }

    int dist() {
        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}

class DijkstraSP {

    private final DirectedEdge[] edgeTo;
    private final int[] distTo;
    private final IndexMinPQ<Integer> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new int[G.V()];
        pq = new IndexMinPQ<>(G.V());

        for (int v = 0; v < G.V(); v++)
            distTo[v] = Integer.MAX_VALUE;

        distTo[s] = 0;

        pq.insert(s, 0);
        while (!pq.isEmpty())
            relax(G, pq.delMin());
    }

    private void relax(EdgeWeightedDigraph G, int v) {
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w))
                    pq.changeKey(w, distTo[w]);
                else
                    pq.insert(w, distTo[w]);
            }
        }
    }


    public int distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Integer.MAX_VALUE;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) return null;

        Stack<DirectedEdge> path = new Stack<DirectedEdge>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()])
            path.push(e);
        return path;
    }
}

class EdgeWeightedDigraph {

    private final List<DirectedEdge>[] adj;
    private final int V;

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        adj = (List<DirectedEdge>[]) new List[V];

        for (int v = 0; v < V; v++)
            adj[v] = new LinkedList<>();
    }

    public int V() {
        return V;
    }

    public void addEdge(DirectedEdge e) {
        adj[e.from()].add(e);
    }

    public Iterable<DirectedEdge> adj(int v) {
        return adj[v];
    }
}

record DirectedEdge(int from, int to, int weight) {
}
