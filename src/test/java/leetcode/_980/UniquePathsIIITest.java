package leetcode._980;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniquePathsIIITest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[][] grid, int expected) {
        assertThat(new UniquePathsIII().uniquePathsIII(grid))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 2, -1}
                }, 2),
                arguments(new int[][]{
                        {1, 0, 0, 0},
                        {0, 0, 0, 0},
                        {0, 0, 0, 2}}, 4),
                arguments(new int[][]{
                        {0, 1},
                        {2, 0}}, 0)
        );
    }
}