package leetcode._409;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestPalindromeTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String s, int expected) {
        assertThat(new LongestPalindrome().longestPalindrome(s))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("abccccdd", 7),
                arguments("a", 1)
        );
    }
}
