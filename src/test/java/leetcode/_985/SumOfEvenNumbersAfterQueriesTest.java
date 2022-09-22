package leetcode._985;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfEvenNumbersAfterQueriesTest {

    @Test
    void dataSet1() {
        var nums = new int[]{1, 2, 3, 4};
        var queries = new int[][]{{1, 0}, {-3, 1}, {-4, 0}, {2, 3}};

        assertThat(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(nums, queries))
                .containsExactly(8, 6, 2, 4);
    }

    @Test
    void dataSet2() {
        var nums = new int[]{1};
        var queries = new int[][]{{4, 0}};

        assertThat(new SumOfEvenNumbersAfterQueries().sumEvenAfterQueries(nums, queries))
                .containsExactly(0);
    }
}