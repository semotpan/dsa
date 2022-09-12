package leetcode._214;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ShortestPalindromeTest {

    @Test
    void test1() {
        var s = "aacecaaa";

        assertThat(new ShortestPalindrome().shortestPalindrome(s))
                .isEqualTo("aaacecaaa");
    }

    @Test
    void test2() {
        var s = "abcd";

        assertThat(new ShortestPalindrome().shortestPalindrome(s))
                .isEqualTo("dcbabcd");
    }
}
