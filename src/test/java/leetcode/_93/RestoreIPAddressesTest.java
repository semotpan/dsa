package leetcode._93;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RestoreIPAddressesTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(String digits, List<String> expected) {
        assertThat(new RestoreIPAddresses().restoreIpAddresses(digits))
                .containsExactlyInAnyOrderElementsOf(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                Arguments.arguments("25525511135", List.of("255.255.11.135", "255.255.111.35")),
                Arguments.arguments("0000", List.of("0.0.0.0")),
                Arguments.arguments("101023", List.of("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"))
        );
    }
}