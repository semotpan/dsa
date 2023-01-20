package leetcode._491;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences {

    private final List<List<Integer>> subsequences = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        back(nums, 0, new ArrayList<>());
        return new ArrayList<>(subsequences);
    }

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
