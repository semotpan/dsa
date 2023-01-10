package leetcode._100;

import leetcode.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SameTreeTest {

    @ParameterizedTest
    @MethodSource("dataset")
    void testing(TreeNode p, TreeNode q, boolean expected) {
        assertThat(new SameTree().isSameTree(p, q))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> dataset() {
        return Stream.of(
                arguments(
                        TreeNode.of(1, TreeNode.of(2), TreeNode.of(3)),
                        TreeNode.of(1, TreeNode.of(2), TreeNode.of(3))
                        , true),
                arguments(
                        TreeNode.of(1, TreeNode.of(2), null),
                        TreeNode.of(1, null, TreeNode.of(2))
                        , false),
                arguments(
                        TreeNode.of(1, TreeNode.of(2), TreeNode.of(1)),
                        TreeNode.of(1, TreeNode.of(1), TreeNode.of(2))
                        , false)
        );
    }

}