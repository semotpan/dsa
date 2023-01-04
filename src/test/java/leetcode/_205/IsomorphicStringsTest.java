package leetcode._205;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class IsomorphicStringsTest {
    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String s, String t, boolean expected) {
        assertThat(new IsomorphicStrings().isIsomorphic(s, t))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("egg", "add", true),
                arguments("foo", "bar", false)
        );
    }

}