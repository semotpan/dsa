package leetcode._1908;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GameOfNimTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int[] piles, boolean expected) {
        assertThat(new GameOfNim().nimGame(piles))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{1}, true),
                arguments(new int[]{1, 1}, false),
                arguments(new int[]{1, 2, 3}, false)
        );
    }
}