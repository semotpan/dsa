package leetcode._409;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        var frequency = new int[58];

        for (int i = 0; i < s.length(); i++) {
            frequency[s.charAt(i) - 'A']++;
        }

        int even = 0, odd = 0;
        for (int i = 0; i < 58; i++) {
            if (frequency[i] > 1) {
                var temp = frequency[i] % 2;
                even = even + (frequency[i] - temp);
                frequency[i] = temp;
            }

            if (frequency[i] == 1) {
                odd = 1;
            }
        }

        return even + odd;
    }
}
