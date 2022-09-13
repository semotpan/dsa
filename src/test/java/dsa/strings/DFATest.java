package dsa.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DFATest {

    @Test
    void test1() {
        var pat = "ABABACA";
        var text = "ABABACRAASDTDASCVABABACAAREVSDGTVABABACA";
        var kmp = new DFA(pat);

        assertThat(kmp.search(text))
                .isEqualTo(17);
    }

}