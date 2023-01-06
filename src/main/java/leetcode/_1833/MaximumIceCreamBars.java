package leetcode._1833;

import java.util.PriorityQueue;

public class MaximumIceCreamBars {


    public int maxIceCream(int[] costs, int coins) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(costs.length);
        for (var cost : costs) {
            pq.add(cost);
        }

        var count = 0;
        while (!pq.isEmpty() && (coins - pq.peek()) >= 0) {
            coins = coins - pq.poll();
            count++;
        }

        return count;
    }

    public int maxIceCreamCountingSort(int[] costs, int coins) {
        var maxCost = maxCost(costs);
        var frequency = frequency(costs, maxCost);

        var icecreams = 0;
        for (var cost = 1; cost <= maxCost; cost++) {
            if (frequency[cost] == 0) {
                continue;
            }

            if (coins < cost) {
                break;
            }

            var count = Integer.min(frequency[cost], coins / cost);
            coins = coins - cost * count;
            icecreams = icecreams + count;
        }

        return icecreams;
    }

    private int[] frequency(int[] costs, int n) {
        var frequency = new int[n + 1];

        for (var cost : costs) {
            ++frequency[cost];
        }

        return frequency;
    }

    private int maxCost(int[] costs) {
        var maxCost = Integer.MIN_VALUE;

        for (var cost : costs) {
            if (maxCost < cost) {
                maxCost = cost;
            }
        }

        return maxCost;
    }

}
