package leetcode._3;

// Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.BitSet;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        var marker = new BitSet(127);
        int max = 0, low = 0;

        for (var i = 0; i < s.length(); ) {
            if (!marker.get(s.charAt(i))) {
                marker.set(s.charAt(i));
                i++;
                continue;
            }

            max = Integer.max(max, i - low);

            while (s.charAt(low) != s.charAt(i)) {
                marker.set(s.charAt(low), false);
                low++;
            }

            marker.set(s.charAt(low), false);
            low++;
        }

        return Integer.max(max, s.length() - low);
    }
}
