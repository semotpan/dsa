package leetcode._131;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private final List<List<String>> palindromes = new ArrayList<>();

    public List<List<String>> partition(String s) {
        var dp = new boolean[s.length()][s.length()];
        back(s, dp, 0, new ArrayList<>());
        return palindromes;
    }

    private void back(String s, boolean[][] dp, int x, List<String> current) {
        if (x == s.length())
            palindromes.add(new ArrayList<>(current));

        for (int i = x; i < s.length(); ++i) {
            if (s.charAt(x) == s.charAt(i) && isNextValid(dp, x, i)) {
                dp[x][i] = true;
                current.add(s.substring(x, i + 1));
                back(s, dp, i + 1, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private static boolean isNextValid(boolean[][] dp, int x, int i) {
        // is i - x < 3, either 1 or 2? or interval already seen
        return i < (x + 3) || dp[x + 1][i - 1];
    }

    boolean isPalindrome(String p) {
        for (int low = 0, high = p.length() - 1; low < high; low++, high--) {
            if (p.charAt(low) != p.charAt(high))
                return false;
        }

        return true;
    }
}
