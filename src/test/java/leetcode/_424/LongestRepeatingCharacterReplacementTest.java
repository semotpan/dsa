package leetcode._424;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestRepeatingCharacterReplacementTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String s, int k, int expected) {
        assertThat(new LongestRepeatingCharacterReplacement().characterReplacement(s, k))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("ABAB", 2, 4),
                arguments("AABABBA", 1, 4),
                arguments("AAAA", 0, 4)
        );
    }
}