package leetcode._277;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindTheCelebrityTest {

    @Test
    void graph1() {
        var N = 3;
        int[][] graph = {
                {1, 1, 0},
                {0, 1, 0},
                {1, 1, 1}
        };

        FindTheCelebrity.Solution solution = new FindTheCelebrity.Solution();
        solution.initGraph(graph);

        assertThat(solution.findCelebrity(N))
                .isEqualTo(1);
    }

    @Test
    void graph2() {
        var N = 3;
        int[][] graph = {
                {1, 0, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        var solution = new FindTheCelebrity.Solution();
        solution.initGraph(graph);

        assertThat(solution.findCelebrity(N))
                .isEqualTo(-1);
    }

}