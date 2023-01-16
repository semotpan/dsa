package leetcode._394;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DecodeStringTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String s, String expected) {
        assertThat(new DecodeString().decodeString(s))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("3[a]2[bc]", "aaabcbc"),
                arguments("3[a2[c]]", "accaccacc"),
                arguments("2[abc]3[cd]ef", "abcabccdcdcdef")
        );
    }
}