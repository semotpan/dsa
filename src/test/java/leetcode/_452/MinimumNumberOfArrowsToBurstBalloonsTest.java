package leetcode._452;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumNumberOfArrowsToBurstBalloonsTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[][] points, int expected) {
        assertThat(new MinimumNumberOfArrowsToBurstBalloons().findMinArrowShots(points))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}, 2),
                arguments(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}, 4),
                arguments(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}, 2),
                arguments(new int[][]{{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}}, 2),
                arguments(new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}}, 2)
        );
    }
}