package leetcode._134;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GasStationTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] gas, int[] cost, int expected) {
        assertThat(new GasStation().canCompleteCircuit(gas, cost))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
                arguments(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1)
        );
    }
}