package dsa.strings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LevenshteinDistanceAlgorithmTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(String a, String b, int expected) {
        assertThat(new LevenshteinDistanceAlgorithm().findDistanceMemo(a.toCharArray(), b.toCharArray()))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("horse", "ros", 3),
                arguments("intention", "execution", 5)
        );
    }
}
