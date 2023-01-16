package leetcode._844;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BackspaceStringCompareTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String s, String t, boolean expected) {
        assertThat(new BackspaceStringCompare().backspaceCompare(s, t))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("ab#c", "ad#c", true),
                arguments("ab##", "c#d#", true),
                arguments("a#c", "b", false)
        );
    }

}