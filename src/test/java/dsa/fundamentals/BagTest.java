package dsa.fundamentals;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.IterableAssert.assertThatIterable;

class BagTest {

    @Test
    void creation() {
        var bag = new Bag<String>(1);

        assertThat(bag.isEmpty()).isTrue();

        bag.add("Item 1");
        bag.add("Item 2");

        assertThat(bag.size())
                .isEqualTo(2);

        assertThatIterable(bag)
                .containsExactly("Item 1", "Item 2");
    }
}