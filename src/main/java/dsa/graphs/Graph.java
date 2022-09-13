package dsa.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Adjacency-list undirected Graph representation
 */
public final class Graph {

    private final List<Integer>[] adj;
    private final int V;
    private int E;

    public Graph(int V) {
        this.V = V;

        adj = (List<Integer>[]) new List[V];
        for (var i = 0; i < V; i++)
            adj[i] = new LinkedList<>();
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    // count self-loops
    public int numberOfSelfLoops() {
        var count = 0;
        for (var v = 0; v < V(); v++) {
            for (var w : adj(v)) {
                if (v == w) {
                    count++;
                }
            }
        }

        return count / 2;   // each edge counted twice
    }

    // out degree
    public int degree(int v) {
        return adj[v].size();
    }

    // compute max (out)degree
    public int maxDegree() {
        var max = 0;
        for (var v = 0; v < V(); v++) {
            max = Integer.max(degree(v), max);
        }

        return max;
    }

    // compute average (out)degree
    public int avgDegree() {
        return 2 * E() / V();
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(this.getClass().getSimpleName()).append("={'")
                .append(V()).append(" vertices, ")
                .append(E()).append(" edges' adj=[")
                .append(IntStream.range(0, V())
                        .mapToObj(v -> {
                            var joiner = new StringJoiner(",");
                            adj(v).forEach(w -> joiner.add(Integer.toString(w)));
                            return "[" + v + ": " + joiner + "]";
                        })
                        .collect(Collectors.joining()))
                .append("]")
                .append("}")
                .toString();
    }
}
