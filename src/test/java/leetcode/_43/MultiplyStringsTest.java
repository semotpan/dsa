package leetcode._43;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MultiplyStringsTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(String num1, String num2, String expected) {
        assertThat(new MultiplyStrings().multiply(num1, num2))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments("2", "3", "6"),
                arguments("123", "456", "56088"),
                arguments("4154", "51454", "213739916"),
                arguments("654154154151454545415415454", "63516561563156316545145146514654", "41549622603955309777243716069997997007620439937711509062916")
        );
    }
}