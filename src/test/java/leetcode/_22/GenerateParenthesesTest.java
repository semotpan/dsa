package leetcode._22;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class GenerateParenthesesTest {

    @Test
    void dataSet1() {
        assertThat(new GenerateParentheses().generateParenthesis(3))
                .contains("((()))", "(()())", "(())()", "()(())", "()()()");
    }

    @Test
    void dataSet2() {
        assertThat(new GenerateParentheses().generateParenthesis(1))
                .containsExactly("()");
    }
}
