package leetcode._227;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class BasicCalculatorIITest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String s, int expected) {
        assertThat(new BasicCalculatorII().calculate(s))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("3+2*2", 7),
                arguments(" 3/2 ", 1),
                arguments(" 3+5 / 2 ", 5),
                arguments("3 +2*12 +   15 / 3 ", 32),
                arguments("1-1+1", 1),
                arguments("12-3*4", 0),
                arguments("1-1-1", -1),
                arguments("1*2-3/4+5*6-7*8+9/10", -24)
        );
    }
}