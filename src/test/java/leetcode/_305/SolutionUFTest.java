package leetcode._305;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionUFTest {

    @Test
    void position1() {
        var m = 3;
        var n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {2, 1}};

        System.out.println(new SolutionUF().numIslands2(m, n, positions));
        assertThat(new SolutionUF().numIslands2(m, n, positions))
                .containsExactly(1, 1, 2, 3);
    }

    @Test
    void position2() {
        var m = 1;
        var n = 1;
        int[][] positions = {{0, 0}};

        assertThat(new SolutionUF().numIslands2(m, n, positions))
                .containsExactly(1);
    }

    @Test
    void position3() {
        var m = 1;
        var n = 2;
        int[][] positions = {{0, 1}, {0, 0}};

        assertThat(new SolutionUF().numIslands2(m, n, positions))
                .containsExactly(1, 1);
    }


    @Test
    void position4() {
        var m = 3;
        var n = 3;
        int[][] positions = {{0, 0}, {0, 1}, {1, 2}, {1, 2}};

        System.out.println(new SolutionUF().numIslands2(m, n, positions));
        assertThat(new SolutionUF().numIslands2(m, n, positions))
                .containsExactly(1, 1, 2, 2);
    }

}