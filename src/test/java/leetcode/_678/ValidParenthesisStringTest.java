package leetcode._678;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesisStringTest {

    @Test
    void dataSet1() {
        var s = "()";

        assertThat(new ValidParenthesisString().checkValidString(s))
                .isTrue();
    }

    @Test
    void dataSet2() {
        var s = "(*)";

        assertThat(new ValidParenthesisString().checkValidString(s))
                .isTrue();
    }

    @Test
    void dataSet3() {
        var s = "(*))";

        assertThat(new ValidParenthesisString().checkValidString(s))
                .isTrue();
    }

    @Test
    void dataSet4() {
        var s = "((((()*)(*)*))())())(()())())))((**)))))(()())()";

        assertThat(new ValidParenthesisString().checkValidString(s))
                .isFalse();
    }
}