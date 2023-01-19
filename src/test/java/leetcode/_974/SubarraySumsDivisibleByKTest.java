package leetcode._974;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SubarraySumsDivisibleByKTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] nums, int k, int expected) {
        assertThat(new SubarraySumsDivisibleByK().subarraysDivByK(nums, k))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{4, 5, 0, -2, -3, 1}, 5, 7),
                arguments(new int[]{5}, 9, 0)
        );
    }
}