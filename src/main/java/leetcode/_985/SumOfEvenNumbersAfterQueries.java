package leetcode._985;

public class SumOfEvenNumbersAfterQueries {

    public int[] sumEvenAfterQueries(int[] V, int[][] queries) {
        var sum = 0;
        for (int v : V)
            if ((v & 1) == 0)
                sum += v;

        var answer = new int[queries.length];

        for (var i = 0; i < queries.length; i++) {
            int value = queries[i][0], index = queries[i][1];
            if ((V[index] & 1) == 0)
                sum -= V[index];

            V[index] += value;
            if ((V[index] & 1) == 0)
                sum += V[index];

            answer[i] = sum;
        }

        return answer;
    }
}
