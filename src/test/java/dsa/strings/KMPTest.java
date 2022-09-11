package dsa.strings;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class KMPTest {

    @Test
    void searching() {
        var pattern = "ABCABC";
        var text = "ABCABCDEFFSCABCABCPOPABCABQPABCABCATC";

        var kmp = new KMP(pattern);
        var indexes = kmp.search(text);

        assertThat(indexes)
                .containsExactly(0, 12, 28);
    }
}