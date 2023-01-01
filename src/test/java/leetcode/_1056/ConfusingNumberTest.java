package leetcode._1056;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConfusingNumberTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int value, boolean expected) {
        assertThat(new ConfusingNumber().confusingNumber(value))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(109, true),
                arguments(150, false),
                arguments(89, true),
                arguments(600, true),
                arguments(101, false)
        );
    }
}