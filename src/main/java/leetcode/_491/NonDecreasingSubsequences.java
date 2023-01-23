package leetcode._491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class NonDecreasingSubsequences {

    private final List<List<Integer>> subsequences = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        back(nums, 0, new ArrayList<>());
//        back(nums, 0, Integer.MIN_VALUE, new ArrayList<>());
        return new ArrayList<>(subsequences);
    }

    // 100% 3ms
    private void back(int[] nums, int x, int last, List<Integer> acc) {
        if (x == nums.length) {
            if (acc.size() > 1)
                subsequences.add(new ArrayList<>(acc));
            return;
        }

        if (nums[x] >= last) {
            acc.add(nums[x]);
            back(nums, x + 1, nums[x], acc);
            acc.remove(acc.size() - 1);
        }

        if (nums[x] != last) {
            back(nums, x + 1, last, acc);
        }
    }

    // 5ms 98%
    private void back(int[] nums, int x, List<Integer> acc) {
        if (acc.size() > 1)
            subsequences.add(new ArrayList<>(acc));

        var unique = new HashSet<>();

        for (int i = x; i < nums.length; ++i) {
            if (!acc.isEmpty() && nums[i] < acc.get(acc.size() - 1)) continue;
            if (unique.contains(nums[i])) continue;

            unique.add(nums[i]);

            acc.add(nums[i]);
            back(nums, i + 1, acc);
            acc.remove(acc.size() - 1);
        }
    }
}
