package leetcode._1626;

import java.util.Arrays;

public class BestTeamWithNoConflicts {

    public int bestTeamScore(int[] scores, int[] ages) {
        var ageScore = new int[scores.length][2];

        var maxSum = 0;
        for (int i = 0; i < scores.length; i++) {
            ageScore[i][0] = ages[i];
            ageScore[i][1] = scores[i];

            maxSum = Integer.max(maxSum, scores[i]); // if there is already the highest score
        }

        Arrays.sort(ageScore, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);

        var dp = new int[scores.length];
        for (int i = 0; i < scores.length; ++i)
            dp[i] = ageScore[i][1];

        for (int i = 0; i < scores.length; ++i) {
            for (int j = i - 1; j >= 0; --j) { // find a better result
                if (ageScore[i][1] >= ageScore[j][1])
                    dp[i] = Integer.max(dp[i], dp[j] + ageScore[i][1]);
            }
            maxSum = Integer.max(maxSum, dp[i]); // select a better result
        }

        return maxSum;
    }
}
