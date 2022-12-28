package leetcode._1962;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class RemoveStonesToMinimizeTotalTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] piles, int k, int expected) {
        assertThat(new RemoveStonesToMinimizeTotal().minStoneSum(piles, k))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{5, 4, 9}, 2, 12),
                arguments(new int[]{4, 3, 6, 7}, 3, 12)
        );
    }
}