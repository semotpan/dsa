package leetcode._944;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DeleteColumnsToMakeSortedTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(String[] values, int expected) {
        assertThat(new DeleteColumnsToMakeSorted().minDeletionSize(values))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(new String[]{"cba", "daf", "ghi"}, 1),
                arguments(new String[]{"a", "b"}, 0),
                arguments(new String[]{"zyx", "wvu", "tsr"}, 3)
        );
    }
}