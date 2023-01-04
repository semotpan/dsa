package leetcode._2244;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToCompleteAllTasks {

    public int minimumRounds(int[] tasks) {
//        return withCounting(tasks);
        return withSorting(tasks);
    }

    // using counting (map)
    // Time: 88ms (39.83%)
    // Memory: 110.4v MB (11.31%)
    private int withCounting(int[] tasks) {
        Map<Integer, Integer> freq = new HashMap<>();

        for (int task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        int min = 0;
        for (int count : freq.values()) {
            if (count == 1) {
                return -1;
            }
            min += minRounds(count);
        }

        return min;
    }

    // using sorting
    // Time: 10ms (98.96%)
    // Memory: 52.2MB (95.48%)
    private int withSorting(int[] tasks) {
        if (tasks.length == 1) {
            return -1;
        }

        Arrays.sort(tasks);  // n*log(n)

        var min = 0;
        for (int i = 0; i < tasks.length; i++) {
            var count = 1;
            while ((i + 1) < tasks.length && tasks[i] == tasks[i + 1]) {
                i++;
                count++;
            }

            if (count == 1) {
                return -1;
            }

            min += minRounds(count);
        }

        return min;
    }

    private int minRounds(int taskAmount) {
        return taskAmount % 3 == 0 ? taskAmount / 3 : (taskAmount / 3 + 1);
    }
}
