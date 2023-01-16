package leetcode._57;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class InsertIntervalTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[][] intervals, int[] newInterval, int[][] expected) {
        assertThat(new InsertInterval().insert(intervals, newInterval))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}, new int[][]{{1, 5}, {6, 9}}),
                arguments(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8}, new int[][]{{1, 2}, {3, 10}, {12, 16}}),
                arguments(new int[][]{{1, 5}}, new int[]{2, 7}, new int[][]{{1, 7}}),
                arguments(new int[][]{{1, 5}}, new int[]{6, 8}, new int[][]{{1, 5}, {6, 8}}),
                arguments(new int[][]{{1, 5}}, new int[]{0, 0}, new int[][]{{0, 0}, {1, 5}})
        );
    }
}