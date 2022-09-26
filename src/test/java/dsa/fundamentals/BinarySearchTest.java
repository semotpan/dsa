package dsa.fundamentals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BinarySearchTest {

    @Test
    void searching() {
        int[] a = {1, 5, 8, 10};
        int key = 1;


        assertThat(BinarySearch.rank(key, a))
                .isEqualTo(0);

        key = 2;

        assertThat(BinarySearch.rank(key, a))
                .isEqualTo(-1);
    }
}
