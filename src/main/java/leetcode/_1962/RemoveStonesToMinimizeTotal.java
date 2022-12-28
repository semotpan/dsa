package leetcode._1962;

import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTotal {
    public int minStoneSum(int[] piles, int k) {
        var heap = new PriorityQueue<Integer>(piles.length, (o1, o2) -> o2 - o1);

        var sum = 0;
        for (int pile : piles) {
            sum += pile;
            heap.add(pile);
        }

        while (k > 0) {
            var max = heap.poll();
            var value = Math.floorDiv(max, 2) + Math.floorMod(max, 2);
            heap.add(value);
            sum += value - max;
            k--;
        }

        return sum;
    }
}
