package leetcode._200;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionDFSTest {

    @Test
    void grid1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        assertThat(new SolutionDFS().numIslands(grid))
                .isEqualTo(1);
    }

    @Test
    void grid2() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        assertThat(new SolutionDFS().numIslands(grid))
                .isEqualTo(3);
    }

}