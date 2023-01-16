package leetcode._692;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TopKFrequentWordsTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String[] words, int k, List<String> expected) {
        assertThat(new TopKFrequentWords().topKFrequent(words, k))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new String[]{"i", "love", "leetcode", "i", "love", "coding"}, 2, List.of("i", "love")),
                arguments(new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"}, 4, List.of("the", "is", "sunny", "day"))
        );
    }
}