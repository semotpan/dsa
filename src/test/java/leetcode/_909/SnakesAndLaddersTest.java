package leetcode._909;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SnakesAndLaddersTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int[][] board, int expected) {
        assertThat(new SnakesAndLadders().snakesAndLadders(board))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[][]{
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 35, -1, -1, 13, -1},
                        {-1, -1, -1, -1, -1, -1},
                        {-1, 15, -1, -1, -1, -1},
                }, 4)
                , arguments(new int[][]{
                        {-1, -1},
                        {-1, 3},
                }, 1)
                , arguments(new int[][]{
                        {-1, -1, -1},
                        {-1, 9, 8},
                        {-1, 8, 9},
                }, 1)
        );
    }
}