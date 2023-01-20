package leetcode._491;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class NonDecreasingSubsequencesTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] nums, List<List<Integer>> expected) {
        assertThat(new NonDecreasingSubsequences().findSubsequences(nums))
                .usingRecursiveComparison()
                .ignoringCollectionOrder()
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{4, 6, 7, 7}, List.of(
                        List.of(4, 6),
                        List.of(4, 6, 7),
                        List.of(4, 6, 7, 7),
                        List.of(4, 7),
                        List.of(4, 7, 7),
                        List.of(6, 7),
                        List.of(6, 7, 7),
                        List.of(7, 7)
                )),
                arguments(new int[]{4, 4, 3, 2, 1}, List.of(List.of(4, 4))),
                arguments(new int[]{-4, 4, 3, 2, 4}, List.of(
                        List.of(-4, 4),
                        List.of(-4, 4, 4),
                        List.of(-4, 3),
                        List.of(-4, 3, 4),
                        List.of(-4, 2),
                        List.of(-4, 2, 4),
                        List.of(4, 4),
                        List.of(3, 4),
                        List.of(2, 4)))
        );
    }
}
