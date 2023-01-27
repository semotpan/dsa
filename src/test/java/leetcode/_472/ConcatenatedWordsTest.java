package leetcode._472;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConcatenatedWordsTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(String[] words, List<String> expected) {
        assertThat(new TrieSolution().findAllConcatenatedWordsInADict(words))
                .containsExactlyInAnyOrderElementsOf(expected);

    }

    private static Stream<Arguments> dataset() {

        return Stream.of(
                arguments(new String[]{"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"},
                        List.of("catsdogcats", "dogcatsdog", "ratcatdogcat")),
                arguments(new String[]{"cat", "dog", "catdog"},
                        List.of("catdog")),
                arguments(new String[]{"a", "b", "ab", "abc"},
                        List.of("ab")));
    }
}