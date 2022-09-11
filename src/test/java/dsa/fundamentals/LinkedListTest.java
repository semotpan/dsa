package dsa.fundamentals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LinkedListTest {

    @Test
    void creation() {

        var list = new LinkedList<Integer>();

        list.add(10);
        list.add(112);
        list.add(20);
        list.add(10);
        list.add(100);
        list.add(23);

        assertThat(list.size())
                .isEqualTo(6);

        assertThat(list.get(1))
                .isEqualTo(112);

        assertThat(list.remove(Integer.valueOf(112))).isTrue();

        assertThat(list.size())
                .isEqualTo(5);

        assertThat(list.get(1))
                .isEqualTo(20);

        list.remove(1);
    }
}