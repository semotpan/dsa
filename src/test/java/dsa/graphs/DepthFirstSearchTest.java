package dsa.graphs;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class DepthFirstSearchTest {

    @Test
    void testing() {
        int[][] edges = new int[][]{
                {0, 2},
                {0, 1},
                {0, 5},
                {1, 2},
                {2, 3},
                {2, 4},
                {3, 4},
                {3, 5}
        };
        int V = 6;

        var G = new Graph(V);

        for (var edge : edges) {
            G.addEdge(edge[0], edge[1]);
        }

        var dfs = new DepthFirstSearch(G, 0);

        assertThat(dfs.count())
                .isEqualTo(6);

        assertThat(dfs.marked(5)).isTrue();
    }

}