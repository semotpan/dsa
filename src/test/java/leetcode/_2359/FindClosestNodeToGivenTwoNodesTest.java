package leetcode._2359;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FindClosestNodeToGivenTwoNodesTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int[] edges, int node1, int node2, int expected) {
        assertThat(new FindClosestNodeToGivenTwoNodes().closestMeetingNode(edges, node1, node2))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new int[]{2, 2, 3, -1}, 0, 1, 2)
                , arguments(new int[]{1, 2, -1}, 0, 2, 2)
                , arguments(new int[]{4, 4, 4, 5, 1, 2, 2}, 1, 1, 1)
        );
    }
}