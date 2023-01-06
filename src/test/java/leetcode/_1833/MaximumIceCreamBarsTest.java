package leetcode._1833;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumIceCreamBarsTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] costs, int coins, int expected) {
        assertThat(new MaximumIceCreamBars().maxIceCreamCountingSort(costs, coins))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{1, 3, 2, 4, 1}, 7, 4),
                arguments(new int[]{10, 6, 8, 7, 7, 8}, 5, 0),
                arguments(new int[]{1, 6, 3, 1, 2, 5}, 20, 6)
        );
    }

}