package leetcode._1129;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ShortestPathWithAlternatingColorsTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int n, int[][] redEdges, int[][] blueEdges, int[] expected) {
        assertThat(new ShortestPathWithAlternatingColors().shortestAlternatingPaths(n, redEdges, blueEdges))
                .isEqualTo(expected);

    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{1, 2}, {2, 3}, {3, 1}}, new int[]{0, 1, 2, 3, 7})
        );
    }

}