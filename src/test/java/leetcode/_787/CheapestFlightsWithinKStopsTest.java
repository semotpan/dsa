package leetcode._787;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class CheapestFlightsWithinKStopsTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(In in, int expected) {
        assertThat(new CheapestFlightsWithinKStops().findCheapestPrice(in.n, in.flights, in.src, in.dst, in.k))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new In(4, new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}}, 0, 3, 1), 700)
                , arguments(new In(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1), 200)
                , arguments(new In(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 0), 500)
        );
    }

    record In(int n, int[][] flights, int src, int dst, int k) {
    }
}