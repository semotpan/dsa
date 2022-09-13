package leetcode._3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void test1() {
        var s = "abcabcbb";

        assertThat(new Solution().lengthOfLongestSubstring(s))
                .isEqualTo(3);
    }

    @Test
    void test2() {
        var s = "bbbbb";

        assertThat(new Solution().lengthOfLongestSubstring(s))
                .isEqualTo(1);
    }

    @Test
    void test3() {
        var s = "pwwkew";

        assertThat(new Solution().lengthOfLongestSubstring(s))
                .isEqualTo(3);
    }

    @Test
    void test4() {
        var s = " ";

        assertThat(new Solution().lengthOfLongestSubstring(s))
                .isEqualTo(1);
    }

    @Test
    void test5() {
        var s = "aab";

        assertThat(new Solution().lengthOfLongestSubstring(s))
                .isEqualTo(2);
    }

    @Test
    void test6() {
        var s = "dvdf";

        assertThat(new Solution().lengthOfLongestSubstring(s))
                .isEqualTo(3);
    }
}