package leetcode._62;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class UniquePathsTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int m, int n, int expected) {
        assertThat(new UniquePaths().uniquePaths(m, n))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(3, 7, 28),
                arguments(3, 2, 3)
        );
    }
}