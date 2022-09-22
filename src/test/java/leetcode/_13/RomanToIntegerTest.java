package leetcode._13;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RomanToIntegerTest {

    @Test
    void dataSet1() {
        var s = "III";

        assertThat(new RomanToInteger().romanToInt(s))
                .isEqualTo(3);
    }

    @Test
    void dataSet2() {
        var s = "LVIII";

        assertThat(new RomanToInteger().romanToInt(s))
                .isEqualTo(58);
    }

    @Test
    void dataSet3() {
        var s = "MCMXCIV";

        assertThat(new RomanToInteger().romanToInt(s))
                .isEqualTo(1994);
    }
}
