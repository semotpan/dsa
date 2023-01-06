package leetcode._142;

import leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LinkedListCycleIITest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(ListNode head, ListNode expected) {
        assertThat(new LinkedListCycleII().detectCycle(head))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        var cycle = ListNode.of(2);
        cycle.next = ListNode.of(2, ListNode.of(0, ListNode.of(-4, cycle)));

        return Stream.of(
                arguments(ListNode.of(3, cycle), cycle)
        );
    }
}