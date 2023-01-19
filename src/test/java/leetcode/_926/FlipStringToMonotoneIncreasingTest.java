package leetcode._926;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FlipStringToMonotoneIncreasingTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String s, int expected) {
        assertThat(new FlipStringToMonotoneIncreasing().minFlipsMonoIncr(s))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("00110", 1),
                arguments("11001", 2),
                arguments("010110", 2),
                arguments("00011000", 2),
                arguments("0101100011", 3),
                arguments("10011111110010111011", 5)
        );
    }
}