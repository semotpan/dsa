package leetcode._1088;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ConfusingNumberIITest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int value, int expected) {
        assertThat(new ConfusingNumberII().confusingNumberII(value))
                .isEqualTo(expected);

    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(10, 3),
                arguments(20, 6),
                arguments(100, 19),
                arguments(200, 40),
                arguments(300, 40),
                arguments(400, 40),
                arguments(1000, 107),
                arguments(10000, 587),
                arguments(100000, 3027),
                arguments(1000000000, 1950627)
        );
    }

}