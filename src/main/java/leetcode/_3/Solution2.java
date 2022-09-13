package leetcode._3;

public class Solution2 {

    public int lengthOfLongestSubstring(String s) {
        var offsets = new int[128];
        var max = 0;

        for (int i = 0, low = 0; i < s.length(); i++) {
            low = Integer.max(low, offsets[s.charAt(i)]);
            max = Integer.max(max, i - low + 1);
            offsets[s.charAt(i)] = i + 1;
        }

        return max;
    }
}
