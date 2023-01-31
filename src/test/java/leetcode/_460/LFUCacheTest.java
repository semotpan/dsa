package leetcode._460;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static java.util.Objects.requireNonNull;
import static leetcode._460.LFUCacheTest.Command.get;
import static leetcode._460.LFUCacheTest.Command.put;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LFUCacheTest {
    private static LFUCache lfuCache;

    @BeforeAll
    public static void setUp() {
        lfuCache = new LFUCache(2);
    }

    @ParameterizedTest
    @MethodSource(value = "scenarios")
    void scenarioOutline(Step step) {
        switch (step.command) {
            case put -> lfuCache.put(step.key(), step.value());
            case get -> assertThat(lfuCache.get(step.key()))
                    .isEqualTo(step.value());
        }
    }

    private static Stream<Arguments> scenarios() {
        return Stream.of(
                arguments(new Step(put, 1, 1)),  // (key, value)
                arguments(new Step(put, 2, 2)),
                arguments(new Step(get, 1, 1)),  // get = key, expected=value)
                arguments(new Step(put, 3, 3)),
                arguments(new Step(get, 2, -1)),
                arguments(new Step(get, 3, 3)),
                arguments(new Step(put, 4, 4)),
                arguments(new Step(get, 1, -1)),
                arguments(new Step(get, 3, 3)),
                arguments(new Step(get, 4, 4))
        );
    }

    record Step(Command command, int key, int value) {
        Step {
            requireNonNull(command);
        }
    }

    enum Command {
        put, get
    }
}