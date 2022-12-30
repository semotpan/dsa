package leetcode._797;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AllPathsFromSourceToTargetTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[][] graph, List<List<Integer>> expected) {
        assertThat(new AllPathsFromSourceToTarget().allPathsSourceTarget(graph))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {1, 2},
                                {3},
                                {3},
                                {}},
                        List.of(List.of(0, 1, 3), List.of(0, 2, 3)))
        );
    }
}