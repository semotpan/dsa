package leetcode._148;

import leetcode.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SortListTest {

    @ParameterizedTest
    @MethodSource(value = "dataset")
    void testing(ListNode input, List<Integer> expected) {
        assertThat(new SortList().sortList(input))
                .extracting(list -> {
                    List<Integer> values = new ArrayList<>();
                    while (list != null) {
                        values.add(list.val);
                        list = list.next;
                    }
                    return values;
                })
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(ListNode.of(new int[]{-1, 5, 3, 4, 0}), List.of(-1, 0, 3, 4, 5))
        );
    }
}