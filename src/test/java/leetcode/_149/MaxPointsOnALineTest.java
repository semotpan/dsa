package leetcode._149;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaxPointsOnALineTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[][] points, int expected) {
        assertThat(new MaxPointsOnALine().maxPoints(points))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 1},
                        {2, 2},
                        {3, 3}}, 3),
                arguments(new int[][]{
                        {1, 1},
                        {3, 2},
                        {5, 3},
                        {4, 1},
                        {2, 3},
                        {1, 4}}, 4)
        );
    }
}