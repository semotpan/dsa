package leetcode._2214;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumHealthToBeatGameTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] damage, int armor, int expected) {
        assertThat(new MinimumHealthToBeatGame().minimumHealth(damage, armor))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{2, 7, 4, 3}, 4, 13),
                arguments(new int[]{2, 5, 3, 4}, 7, 10),
                arguments(new int[]{3, 3, 3}, 0, 10),
                arguments(new int[]{3}, 1, 3),
                arguments(new int[]{0}, 0, 1)
        );
    }
}