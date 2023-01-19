package leetcode._918;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MaximumSumCircularSubarrayTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int[] nums, int expected) {
        assertThat(new MaximumSumCircularSubarray().maxSubarraySumCircular(nums))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{1, -2, 3, -2}, 3),
                arguments(new int[]{5, -3, 5}, 10),
                arguments(new int[]{-3, -2, -3}, -2),
                arguments(new int[]{3, -1, 2, -1}, 4),
                arguments(new int[]{9, -4, -7, 9}, 18)
        );
    }
}
