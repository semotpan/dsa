package leetcode._918;

public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        var N = nums.length;
        var max = kadane(nums, N);
        if (max < 0) {
            return max;
        }

        var sum = 0;
        for (var i = 0; i < N; i++) {
            sum += nums[i];
            nums[i] *= -1;
        }
        var circularMax = sum + kadane(nums, N);
        return Integer.max(circularMax, max);
    }

    /**
     * Kadane's Algo - Max SubArray sum
     */
    private int kadane(int[] nums, int N) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;

        for (var i = 0; i < N; ++i) {
            currentSum += nums[i];

            if (maxSum < currentSum)
                maxSum = currentSum;

            if (currentSum < 0)
                currentSum = 0;
        }

        return maxSum;
    }

    /**
     * Kadane's Algo - Min SubArray sum
     */
    int kadaneMinSum(int[] nums) {
        var N = nums.length;
        int minSum = Integer.MAX_VALUE, currentSum = 0;

        for (var i = 0; i < N; ++i) {
            currentSum += nums[i];

            if (minSum > currentSum)
                minSum = currentSum;

            if (currentSum > 0)
                currentSum = 0;
        }

        return minSum;
    }

    /**
     * Kadane's Algo - Max-Min SubArray sum in circular
     */
    int kadaneCircular(int[] nums) {
        int N = nums.length, sum = 0;
        int maxSum = Integer.MIN_VALUE, currentMaxSum = 0;
        int minSum = Integer.MAX_VALUE, currentMinSum = 0;

        for (int i = 0; i < N; ++i) {
            currentMaxSum += nums[i];

            if (currentMaxSum > maxSum)
                maxSum = currentMaxSum;

            if (currentMaxSum < 0)
                currentMaxSum = 0;

            currentMinSum += nums[i];

            if (currentMinSum < minSum)
                minSum = currentMinSum;

            if (currentMinSum > 0)
                currentMinSum = 0;

            sum += nums[i];
        }

        return sum == minSum ? maxSum : Math.max(maxSum, sum - minSum);
    }
}
