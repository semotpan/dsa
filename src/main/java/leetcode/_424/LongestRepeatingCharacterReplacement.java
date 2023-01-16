package leetcode._424;

public class LongestRepeatingCharacterReplacement {

    // slow
    public int characterReplacement(String s, int k) {
        return slidingWindowFast(s, k);
    }

    private int slidingWindowFast(String s, int k) {
        var frequency = new int[26];
        int maxFrequency = 0, longestSubstring = 0;

        for (int i = 0, start = 0; i < s.length(); i++) {
            var c = s.charAt(i) - 'A';

            frequency[c]++;
            maxFrequency = Integer.max(maxFrequency, frequency[c]);

            if ((i + 1 - start - maxFrequency) > k) { // more than k different chars
                var charToRemove = s.charAt(start) - 'A';
                frequency[charToRemove]--;
                start++;
            }

            longestSubstring = i + 1 - start; //the window is valid at this point. size of the window never decreases
        }

        return longestSubstring;
    }

    // SLOW
    private int slidingWindowSlow(String s, int k) {
        int longestSubstring = 0, firstChangeIndex = 0;

        for (int i = 0; i < s.length() - 1; ) {
            var c = s.charAt(i);

            int j = i + 1, changes = 0;
            while (j < s.length() && changes <= k) {
                if (c != s.charAt(j)) {
                    if (changes == 0) {
                        firstChangeIndex = j;
                    }
                    changes++;
                }
                ++j;
            }

            longestSubstring = Integer.max(longestSubstring, j - i - (changes - k));

            if (changes <= k && j == s.length()) break;

            i = firstChangeIndex;
        }

        return Integer.min(longestSubstring, s.length());
    }

}
