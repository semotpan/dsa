package leetcode._1071;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class GreatestCommonDivisorOfStringsTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(String str1, String str2, String expected) {
        assertThat(new GreatestCommonDivisorOfStrings().gcdOfStrings(str1, str2))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("ABCABC", "ABC", "ABC"),
                arguments("ABABAB", "ABAB", "AB"),
                arguments("LEET", "CODE", ""),
                arguments("AA", "A", "A"),
                arguments("EFGABC", "ABC", "")
        );
    }
}