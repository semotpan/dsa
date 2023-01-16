package leetcode._299;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BullsAndCowsTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String secret, String guess, String expected) {
        assertThat(new BullsAndCows().getHint(secret, guess))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("1807", "7810", "1A3B"),
                arguments("1123", "0111", "1A1B")
        );
    }
}