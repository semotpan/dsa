package leetcode._8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StringToInteger_AtoiTest {


    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String value, int expected) {
        assertThat(new StringToInteger_Atoi().myAtoi(value))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("", 0),
                arguments("         ", 0),
                arguments("Hollla", 0),
                arguments("Hollla -", 0),
                arguments("8888-", 8888),
                arguments("-", 0),
                arguments("42", 42),
                arguments("   -42", -42),
                arguments("4193 with words", 4193),
                arguments("words and 987", 0),
                arguments("-91283472332", Integer.MIN_VALUE),
                arguments("20000000000000000000", Integer.MAX_VALUE)
        );
    }

}