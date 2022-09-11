package dsa.fundamentals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnionFindTest {

    @Test
    void creation() {
        var N = 10;
        int[][] pairs = {
                {4, 3}, {3, 8}, {6, 5},
                {9, 4}, {2, 1}, {8, 9},
                {5, 0}, {7, 2}, {6, 1},
                {1, 0}, {6, 7}
        };
        var un = new UnionFind(N);

        for (var pair : pairs) {
            un.union(pair[0], pair[1]);
        }

        assertThat(un.connected(3, 4)).isTrue();
        assertThat(un.count()).isEqualTo(2);

    }

}