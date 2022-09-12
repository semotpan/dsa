package leetcode._214;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        var reverse = new StringBuilder(s).reverse().toString();
        var offset = lpsOffset(s + "#" + reverse);
        return reverse.substring(0, s.length() - offset) + s;
    }

    private int lpsOffset(String pat) {
        var M = pat.length();
        var lps = new int[M];

        var prefix = 0;
        for (var i = 1; i < M; i++) {

            while (prefix > 0 && pat.charAt(prefix) != pat.charAt(i)) {
                prefix = lps[prefix - 1];
            }

            if (pat.charAt(prefix) == pat.charAt(i)) {
                prefix++;
            }

            lps[i] = prefix;
        }

        return lps[M - 1];
    }
}
