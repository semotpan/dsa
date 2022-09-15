package dsa.graphs;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GraphTest {

    @Test
    void creation() {
        var edges = new int[][]{
                {0, 2},
                {0, 1},
                {0, 5},
                {1, 2},
                {2, 3},
                {2, 4},
                {3, 4},
                {3, 5}
        };
        var V = 6;

        var graph = new Graph(V);

        for (var edge : edges) {
            graph.addEdge(edge[0], edge[1]);
        }

        assertThat(graph.V())
                .isEqualTo(6);

        assertThat(graph.E())
                .isEqualTo(8);

        assertThat(graph.degree(0))
                .isEqualTo(3);

        assertThat(graph.avgDegree())
                .isEqualTo(2);

        assertThat(graph.maxDegree())
                .isEqualTo(4);

        assertThat(graph.numberOfSelfLoops())
                .isEqualTo(0);

        assertThat(graph.adj(2))
                .containsExactly(0, 1, 3, 4);

        System.out.println(graph);
    }

}