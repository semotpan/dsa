package dsa.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DepthFirstSearchTest {

    private Graph G;

    @BeforeEach
    void setUp() {
        var V = 6;
        var edges = new int[][]{
                {0, 2}, {0, 1}, {0, 5},
                {1, 2},
                {2, 3}, {2, 4},
                {3, 4}, {3, 5}
        };

        G = new Graph(V, edges);
    }

    @Test
    void testing() {
        var dfs = new DepthFirstSearch(G, 0);

        assertThat(dfs.count())
                .isEqualTo(6);

        assertThat(dfs.marked(5)).isTrue();
    }
}