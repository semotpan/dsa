package leetcode._2421;

import java.util.*;

public class NumberOfGoodPaths {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        return new FrequencyGroups().numberOfGoodPaths(vals, edges);
    }

}

class Sorting {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        Arrays.sort(edges, Comparator.comparingInt(a -> Math.max(vals[a[0]], vals[a[1]])));
        var uf = new UnionFind(vals);

        for (var edge : edges) {
            uf.union(edge[0], edge[1]);
        }

        return uf.count();
    }

    private static final class UnionFind {

        private final int[] id;
        private final int[] rank;
        private final int[] counts;
        private int count;

        UnionFind(int[] rank) {
            this.id = new int[rank.length];
            this.counts = new int[rank.length];
            this.rank = rank;
            this.count = rank.length;

            for (int i = 0; i < rank.length; ++i) {
                id[i] = i;
                counts[i] = 1;
            }
        }

        public int find(int p) {
            while (p != id[p])
                p = id[p];
            return p;
        }

        public void union(int p, int q) {
            var pID = find(p);
            var qID = find(q);

            if (pID == qID)
                return;

            if (rank[pID] == rank[qID]) {
                count += counts[pID] * counts[qID];
                counts[pID] += counts[qID];
                id[qID] = pID;
            } else if (rank[pID] < rank[qID])
                id[pID] = qID;
            else {
                id[qID] = pID;
            }
        }

        public int count() {
            return count;
        }
    }
}

class FrequencyGroups {

    public int numberOfGoodPaths(int[] vals, int[][] edges) {

        var G = new Graph(edges);

        var nodeRanks = new TreeMap<Integer, List<Integer>>();

        for (var i = 0; i < vals.length; ++i) {
            nodeRanks.computeIfAbsent(vals[i], k -> new LinkedList<>()).add(i);
        }

        var uf = new UnionFind(G.V());
        var goodPaths = 0;

        for (var rank : nodeRanks.keySet()) {
            for (var v : nodeRanks.get(rank)) {
                for (var w : G.adj(v)) {
                    if (vals[v] >= vals[w]) {
                        uf.union(v, w);
                    }
                }
            }

            var groups = new HashMap<Integer, Integer>();
            for (var v : nodeRanks.get(rank)) {
                var w = uf.find(v);
                groups.put(w, groups.getOrDefault(w, 0) + 1);
            }

            for (var group : groups.keySet()) {
                var size = groups.get(group);
                goodPaths += size * (size + 1) / 2;
            }
        }

        return goodPaths;
    }

    private static final class UnionFind {

        private final int[] id;
        private final int[] rank;

        UnionFind(int N) {
            this.id = new int[N];
            this.rank = new int[N];

            for (int i = 0; i < N; ++i)
                id[i] = i;
        }

        public int find(int p) {
            while (p != id[p])
                p = id[p];
            return p;
        }

        public void union(int p, int q) {
            var pID = find(p);
            var qID = find(q);

            if (pID == qID)
                return;

            if (rank[pID] > rank[qID])
                id[qID] = pID;
            else if (rank[pID] < rank[qID])
                id[pID] = qID;
            else {
                id[qID] = pID;
                rank[pID]++;
            }
        }
    }

    static final class Graph {

        private final int V;
        private final List<Integer>[] adj;

        Graph(int[][] edges) {
            this.V = edges.length + 1;
            this.adj = new List[this.V];

            for (var i = 0; i < V; ++i) {
                adj[i] = new ArrayList<>();
            }

            for (var edge : edges) {
                adj[edge[0]].add(edge[1]);
                adj[edge[1]].add(edge[0]);
            }
        }

        int V() {
            return V;
        }

        Iterable<Integer> adj(int v) {
            return adj[v];
        }
    }

    static final class DistinctGoodPathFinder {

        private final Graph G;
        private final int[] vals;
        private int count;
        private final boolean[] marked;

        DistinctGoodPathFinder(Graph G, int[] vals) {
            this.G = G;
            this.marked = new boolean[G.V()];
            this.vals = vals;

            var nodeRanks = new TreeMap<Integer, List<Integer>>(Comparator.reverseOrder());

            for (var i = 0; i < vals.length; ++i) {
                nodeRanks.computeIfAbsent(vals[i], k -> new LinkedList<>()).add(i);
            }

            for (var node : nodeRanks.entrySet()) {
                var values = node.getValue();
                if (values.size() > 1) {
                    var v = values.get(0);
                    for (int i = 1; i < values.size(); i++) {
                        if (!marked[v]) {
                            var dfs = dfs(v, v, values.get(i));
                            if (dfs)
                                count++;
                        }
                    }
                }
            }
        }

        private boolean dfs(int v, int start, int end) {
            marked[v] = true;
            if (v == end) {
                return true;
            }

            for (var w : G.adj(v)) {
                if (!marked[w] && vals[start] >= vals[w]) {
                    return dfs(v, w, start);
                }
            }

            return false;
        }

        public int count() {
            return vals.length + count;
        }
    }
}


