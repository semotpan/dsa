package leetcode._352;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static leetcode._352.DataStreamAsDisjointIntervalsTest.Command.add_num;
import static leetcode._352.DataStreamAsDisjointIntervalsTest.Command.get_interval;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class DataStreamAsDisjointIntervalsTest {

    private static SummaryRanges summaryRanges;

    @BeforeAll
    public static void setUp() {
        summaryRanges = new SummaryRanges();
    }

    @ParameterizedTest
    @MethodSource(value = "scenarios")
    void scenarioOutline(Step<Object> step) {
        switch (step.command) {
            case add_num -> summaryRanges.addNum((int) step.payload());
            case get_interval -> assertThat(summaryRanges.getIntervals())
                    .isDeepEqualTo((int[][]) step.payload());
        }
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(new Step<>(add_num, 1)),
                arguments(new Step<>(get_interval, new int[][]{{1, 1}})),
                arguments(new Step<>(add_num, 3)),
                arguments(new Step<>(get_interval, new int[][]{{1, 1}, {3, 3}})),
                arguments(new Step<>(add_num, 7)),
                arguments(new Step<>(get_interval, new int[][]{{1, 1}, {3, 3}, {7, 7}})),
                arguments(new Step<>(add_num, 2)),
                arguments(new Step<>(get_interval, new int[][]{{1, 3}, {7, 7}})),
                arguments(new Step<>(add_num, 6)),
                arguments(new Step<>(get_interval, new int[][]{{1, 3}, {6, 7}}))
        );
    }

    record Step<T>(Command command, T payload) {
        Step {
            requireNonNull(command);
            requireNonNull(payload);
        }
    }

    enum Command {
        add_num, get_interval
    }
}