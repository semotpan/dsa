package leetcode._502;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IPOTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int k, int w, int[] profits, int[] capital, int expected) {
        assertThat(new IPO().findMaximizedCapital(k, w, profits, capital))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(2, 0, new int[]{1, 2, 3}, new int[]{0, 1, 1}, 4),
                arguments(3, 0, new int[]{1, 2, 3}, new int[]{0, 1, 2}, 6)
        );
    }
}