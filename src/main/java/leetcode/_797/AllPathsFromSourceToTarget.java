package leetcode._797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllPathsFromSourceToTarget {

    private final List<List<Integer>> paths = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        path.addLast(0);
        dfs(graph, 0, path);
        return paths;
    }

    private void dfs(int[][] graph, int v, LinkedList<Integer> path) {
        if (v == graph.length - 1) {
            paths.add(new ArrayList<>(path));
            return;
        }

        for (var w : graph[v]) {
            path.addLast(w);
            dfs(graph, w, path);
            path.removeLast();
        }
    }
}
