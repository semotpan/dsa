package leetcode._2244;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MinimumRoundsToCompleteAllTasksTest {
    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[] tasks, int expected) {
        assertThat(new MinimumRoundsToCompleteAllTasks().minimumRounds(tasks))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}, 4),
                arguments(new int[]{2, 3, 3}, -1),
                arguments(new int[]{2}, -1),
                arguments(new int[]{1, 2, 1}, -1)
        );
    }
}