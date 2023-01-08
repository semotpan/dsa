package leetcode._409;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        var frequency = new int[58];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'A']++;
        }

        int size = 0, odd = 0;
        for (int i = 0; i < 58; i++) {
            size += (frequency[i] >> 1) << 1;   // size += (frequency[i] / 2) * 2;
            odd += (frequency[i] & 1);          // odd += (frequency[i] % 2);
        }

        return odd > 0 ? size + 1 : size;
    }
}
