package leetcode._557;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWordsInAStringIIITest {

    @Test
    void reversing1() {
        assertThat(new ReverseWordsInAStringIII().reverseWords("Let's take LeetCode contest"))
                .isEqualTo("s'teL ekat edoCteeL tsetnoc");
    }

    @Test
    void reversing2() {
        assertThat(new ReverseWordsInAStringIII().reverseWords("God Ding"))
                .isEqualTo("doG gniD");
    }

    @Test
    void reversing3() {
        assertThat(new ReverseWordsInAStringIII().reverseWords("God"))
                .isEqualTo("doG");
    }
}