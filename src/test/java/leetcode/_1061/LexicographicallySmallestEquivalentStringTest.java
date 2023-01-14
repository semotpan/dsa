package leetcode._1061;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LexicographicallySmallestEquivalentStringTest {
    @ParameterizedTest
    @MethodSource("dataset")
    void testing(Input input, String expected) {
        assertThat(new LexicographicallySmallestEquivalentString().smallestEquivalentString(input.s1, input.s2, input.baseStr))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new Input("parker", "morris", "parser"), "makkek"),
                arguments(new Input("hello", "world", "hold"), "hdld"),
                arguments(new Input("leetcode", "programs", "sourcecode"), "aauaaaaada")
        );
    }

    record Input(
            String s1,
            String s2,
            String baseStr
    ) {}
}
