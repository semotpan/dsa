package leetcode._2421;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfGoodPathsTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] vals, int[][] edges, int expected) {
        assertThat(new NumberOfGoodPaths().numberOfGoodPaths(vals, edges))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{1, 3, 2, 1, 3}, new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}}, 6),
                arguments(new int[]{1, 1, 2, 2, 3}, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}}, 7),
                arguments(new int[]{1}, new int[][]{}, 1),
                arguments(new int[]{2, 5, 5, 1, 5, 2, 3, 5, 1, 5}, new int[][]{{0, 1}, {2, 1}, {3, 2}, {3, 4}, {3, 5}, {5, 6}, {1, 7}, {8, 4}, {9, 7}}, 20)
        );
    }
}