package dsa.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * KMP (Knuth-Morris-Pratt) algorithm
 * 1. build the lps table (pi - table)
 * 2. call search() , searching is done based on lps
 * <p>
 * Time Complexity -> O(N+M), N - text.length; M - pattern.length()
 * Auxiliary Space -> O(M)
 */

public final class KMP {

    private final String pattern;
    private final int[] lps;

    public KMP(String pattern) {
        this.pattern = pattern;

        var M = pattern.length();
        lps = new int[M];

        // build lps[] table (the 'longest prefix' which are also a 'suffix')
        var prefix = 0;
        for (var i = 1; i < M; i++) {
            while (prefix > 0 && pattern.charAt(prefix) != pattern.charAt(i)) {
                prefix = lps[prefix - 1];
            }

            if (pattern.charAt(prefix) == pattern.charAt(i)) {
                prefix++;
            }

            lps[i] = prefix;
        }
    }

    public List<Integer> search(String text) {
        var N = text.length();
        var M = pattern.length();
        var indexes = new ArrayList<Integer>();

        for (int i = 0, prefix = 0; i < N; i++) {
            // back the pattern index while diff
            while (prefix > 0 && pattern.charAt(prefix) != text.charAt(i)) {
                prefix = lps[prefix - 1];
            }

            if (pattern.charAt(prefix) == text.charAt(i)) {
                prefix++;
            }

            if (prefix == M) {
                indexes.add((i + 1) - M); // pattern found at index ((i + 1) - M)
                prefix = lps[prefix - 1]; // search for next if there exists one
            }
        }

        return indexes;
    }
}
