package leetcode._1249;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumRemoveToMakeValidParenthesesTest {

    @Test
    void dataSet1() {
        var s = "lee(t(c)o)de)";

        assertThat(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s))
                .isEqualTo("lee(t(c)o)de");
    }

    @Test
    void dataSet2() {
        var s = "a)b(c)d";

        assertThat(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s))
                .isEqualTo("ab(c)d");
    }

    @Test
    void dataSet3() {
        var s = "))((";

        assertThat(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s))
                .isEqualTo("");
    }

    @Test
    void dataSet4() {
        var s = "(a(b(c)d)";

        assertThat(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s))
                .isEqualTo("a(b(c)d)");
    }

    @Test
    void dataSet5() {
        var s = ")((c)d()(l";

        assertThat(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s))
                .isEqualTo("(c)d()l");
    }

    @Test
    void dataSet6() {
        var s = ")a(b(c)d()(l";

        assertThat(new MinimumRemoveToMakeValidParentheses().minRemoveToMakeValid(s))
                .isEqualTo("ab(c)d()l");
    }
}