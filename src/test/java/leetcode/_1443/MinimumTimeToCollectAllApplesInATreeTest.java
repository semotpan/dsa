package leetcode._1443;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumTimeToCollectAllApplesInATreeTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int n, int[][] edges, List<Boolean> hasApple, int expected) {
        assertThat(new MinimumTimeToCollectAllApplesInATree().minTime(n, edges, hasApple))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                        List.of(false, false, true, false, true, true, false), 8),
                arguments(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                        List.of(false, false, true, false, false, true, false), 6),
                arguments(7, new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                        List.of(false, false, false, false, false, false, false), 0),
                arguments(4, new int[][]{{0, 2}, {0, 3}, {1, 2}},
                        List.of(false, true, false, false), 4)
        );
    }
}
