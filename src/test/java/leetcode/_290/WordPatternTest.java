package leetcode._290;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WordPatternTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String pattern, String s, boolean expected) {
        assertThat(new WordPattern().wordPattern(pattern, s))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("abba", "dog cat cat dog", true),
                arguments("abba", "dog cat cat fish", false),
                arguments("aaaa", "dog cat cat dog", false),
                arguments("abba", "dog dog dog dog", false)
        );
    }
}