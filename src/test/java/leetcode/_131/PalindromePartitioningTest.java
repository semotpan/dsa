package leetcode._131;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class PalindromePartitioningTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(String s, List<List<String>> expected) {
        assertThat(new PalindromePartitioning().partition(s))
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("aab", List.of(List.of("a", "a", "b"), List.of("aa", "b"))),
                arguments("a", List.of(List.of("a"))),
                arguments("abba",
                        List.of(
                                List.of("a", "b", "b", "a"),
                                List.of("a", "bb", "a"),
                                List.of("abba"))),
                arguments("aabaa",
                        List.of(List.of("a", "a", "b", "a", "a"),
                                List.of("a", "a", "b", "aa"),
                                List.of("a", "aba", "a"),
                                List.of("aa", "b", "a", "a"),
                                List.of("aa", "b", "aa"),
                                List.of("aabaa")))

        );
    }
}