package leetcode._974;

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        int counter = 0, N = nums.length;
        var prefixSums = prefixSums(nums, N);

        var buckets = new int[k];
        buckets[0] = 1;

        for (int bucket, i = 0; i < N; ++i) {
            bucket = prefixSums[i] % k;
            if (bucket < 0)
                bucket += k;

            counter += buckets[bucket];
            buckets[bucket]++;
        }

        return counter;
    }

    private int[] prefixSums(int[] nums, int N) {
        var prefixSums = new int[N];

        prefixSums[0] = nums[0];
        for (var i = 1; i < N; ++i) {
            prefixSums[i] = prefixSums[i - 1] + nums[i];
        }
        return prefixSums;
    }

    // TLE
    public int subarraysDivByK2(int[] nums, int k) {

        int counter = 0, N = nums.length;
        var prefixSums = prefixSums(nums, N);

        for (int i = N - 1; i >= 0; --i) {
            var currSum = prefixSums[i];

            if (currSum % k == 0) {
                counter++;
            }

            for (int r = i + 1; r < N; r++) {
                if ((currSum - prefixSums[r]) % k == 0) {
                    counter++;
                }
            }
        }
        return counter;
    }

}
