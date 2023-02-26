package dsa.strings;

/**
 * The Levenshtein distance (a.k.a edit distance) is a measure of similarity between two strings.
 * It is defined as the minimum number of changes required to convert string a into string b (this is done by inserting, deleting or replacing a character in string a).
 * The smaller the Levenshtein distance, the more similar the strings are.
 */
public class LevenshteinDistanceAlgorithm {

    public int findDistance(char[] a, char[] b) {
        var N = a.length;
        var M = b.length;

        var dp = new int[N + 1][M + 1];

        // Initialising first row:
        for (var r = 0; r <= N; ++r)
            dp[r][0] = r;

        // Initialising first column:
        for (var c = 0; c <= M; ++c)
            dp[0][c] = c;

        int insertion, deletion, replacement;

        for (var r = 1; r <= N; ++r) {
            for (var c = 1; c <= M; ++c) {
                if (a[r - 1] == b[c - 1]) {
                    dp[r][c] = dp[r - 1][c - 1];
                } else {
                    // Choosing the best option:
                    insertion = dp[r][c - 1];
                    deletion = dp[r - 1][c];
                    replacement = dp[r - 1][c - 1];

                    dp[r][c] = 1 + min(insertion, deletion, replacement);
                }
            }
        }

        return dp[N][M];
    }


    private int min(int insertion, int deletion, int replacement) {
        if (insertion <= deletion && insertion <= replacement)
            return insertion;
        else if (deletion <= insertion && deletion <= replacement)
            return deletion;
        else
            return replacement;
    }

    public int findDistanceMemo(char[] a, char[] b) {

        var N = a.length;
        var M = b.length;

        if (N < M)
            return findDistanceMemo(b, a);

        var dp = new int[M];
        int last = 0, diag;
        for (int i = 0; i < M; i++)
            dp[i] = M - i;

        for (int i = N - 1; i > -1; i--) {
            last = N - i;
            diag = N - 1 - i;
            for (int j = M - 1; j > -1; j--) {
                int tmp = dp[j];
                if (a[i] == b[j])
                    last = dp[j] = diag;
                else
                    last = dp[j] = Math.min(diag, Math.min(dp[j], last)) + 1;

                diag = tmp;
            }
        }
        return last;
    }
}
