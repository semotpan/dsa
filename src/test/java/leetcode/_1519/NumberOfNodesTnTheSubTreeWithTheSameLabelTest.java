package leetcode._1519;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NumberOfNodesTnTheSubTreeWithTheSameLabelTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int n, int[][] edges, String labels, int[] expected) {
        assertThat(new NumberOfNodesTnTheSubTreeWithTheSameLabel().countSubTrees(n, edges, labels))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                        "abaedcd", new int[]{2, 1, 1, 1, 1, 1, 1}),
                arguments(4, new int[][]{{0, 1}, {1, 2}, {0, 3}},
                        "bbbb", new int[]{4, 2, 1, 1}),
                arguments(5, new int[][]{{0, 1}, {0, 2}, {1, 3}, {0, 4}},
                        "aabab", new int[]{3, 2, 1, 1, 1})
        );
    }
}