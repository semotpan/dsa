package leetcode._1626;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BestTeamWithNoConflictsTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int[] scores, int[] ages, int expected) {
        assertThat(new BestTeamWithNoConflicts().bestTeamScore(scores, ages))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{1, 3, 5, 10, 15}, new int[]{1, 2, 3, 4, 5}, 34)
                ,arguments(new int[]{4, 5, 6, 5}, new int[]{2, 1, 2, 1}, 16)
                ,arguments(new int[]{1, 2, 3, 5}, new int[]{8, 9, 10, 1}, 6)
        );
    }

}