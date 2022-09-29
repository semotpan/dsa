package leetcode._2116;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CheckIfAParenthesesStringCanBeValidTest {

    @Test
    void dataSet1() {
        String s = "))()))", locked = "010100";

        assertThat(new CheckIfAParenthesesStringCanBeValid().canBeValid(s, locked))
                .isTrue();
    }

    @Test
    void dataSet2() {
        String s = "()()", locked = "0000";

        assertThat(new CheckIfAParenthesesStringCanBeValid().canBeValid(s, locked))
                .isTrue();
    }

    @Test
    void dataSet3() {
        String s = ")", locked = "0";

        assertThat(new CheckIfAParenthesesStringCanBeValid().canBeValid(s, locked))
                .isFalse();
    }

    @Test
    void dataSet4() {
        String s = ")))(()", locked = "010100";

        assertThat(new CheckIfAParenthesesStringCanBeValid().canBeValid(s, locked))
                .isTrue();
    }
}