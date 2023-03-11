package leetcode._1195;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@Tag("unit")
@Tag("concurrency")
class FizzBuzzMultithreadedTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(int n, Object[] expected) throws InterruptedException {
        var fizzBuzz = new FizzBuzzMultithreaded(n);

        var executor = Executors.newFixedThreadPool(4);
        var latch = new CountDownLatch(4);

        var actual = new Object[n];
        var index = new AtomicInteger();

        List<UncheckRunnable> uncheckRunnable = List.of(
                () -> fizzBuzz.fizz(() -> actual[index.getAndIncrement()] = "fizz"),
                () -> fizzBuzz.buzz(() -> actual[index.getAndIncrement()] = "buzz"),
                () -> fizzBuzz.fizzbuzz(() -> actual[index.getAndIncrement()] = "fizzbuzz"),
                () -> fizzBuzz.number((x) -> actual[index.getAndIncrement()] = x));

        for (var r : uncheckRunnable)
            executor.execute(() -> {
                r.runSafe();
                latch.countDown();
            });

        // Wait all threads to complete
        latch.await();

        executor.shutdown();

        assertThat(actual)
                .usingRecursiveFieldByFieldElementComparator()
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(15, new Object[]{1, 2, "fizz", 4, "buzz", "fizz", 7, 8, "fizz", "buzz", 11, "fizz", 13, 14, "fizzbuzz"}),
                arguments(5, new Object[]{1, 2, "fizz", 4, "buzz"})
        );
    }

    interface UncheckRunnable {

        void run() throws Exception;

        default void runSafe() {
            try {
                run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
