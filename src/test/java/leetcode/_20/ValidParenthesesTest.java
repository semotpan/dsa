package leetcode._20;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {

    @Test
    void dataSet1() {
        var s = "()";

        assertThat(new ValidParentheses().isValid(s))
                .isTrue();
    }

    @Test
    void dataSet2() {
        var s = "()[]{}";

        assertThat(new ValidParentheses().isValid(s))
                .isTrue();
    }

    @Test
    void dataSet3() {
        var s = "(]s";

        assertThat(new ValidParentheses().isValid(s))
                .isFalse();
    }
}
