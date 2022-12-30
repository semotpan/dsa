package leetcode._1834;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SingleThreadedCPUTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(int[][] tasks, int[] expected) {
        assertThat(new SingleThreadedCPU().getOrder(tasks))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(
                        new int[][]{
                                {1, 2},
                                {2, 4},
                                {3, 2},
                                {4, 1}},
                        new int[]{0, 2, 3, 1}),
                arguments(new int[][]{
                                {7, 10},
                                {7, 12},
                                {7, 5},
                                {7, 4},
                                {7, 2}},
                        new int[]{4, 3, 2, 0, 1}),
                arguments(new int[][]{
                                {19, 13},
                                {16, 9},
                                {21, 10},
                                {32, 25},
                                {37, 4},
                                {49, 24},
                                {2, 15},
                                {38, 41},
                                {37, 34},
                                {33, 6},
                                {45, 4},
                                {18, 18},
                                {46, 39},
                                {12, 24}},
                        new int[]{6, 1, 2, 9, 4, 10, 0, 11, 5, 13, 3, 8, 12, 7}));
    }


}