package leetcode._295;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Leetcode
 * >> Time:   154 ms (83.69%)
 * >> Memory: 60.9 MB (95.10%)
 */
public class FindMedianFromDataStream_Heaps {

    private final Queue<Integer> lo; // Max-Heap - store the smaller half of the numbers
    private final Queue<Integer> hi; // Min Heap - store the larger half of the numbers

    public FindMedianFromDataStream_Heaps() {
        lo = new PriorityQueue<>((o1, o2) -> o2 - o1);
        hi = new PriorityQueue<>();
    }

    public void addNum(int num) {
        lo.add(num);                    // add to max heap
        hi.add(lo.poll());              // balancing step

        if (lo.size() < hi.size()) {    // maintain size property
            lo.add(hi.poll());
        }
    }

    public double findMedian() {
        if (lo.size() > hi.size()) {
            return lo.peek();
        }

        return (lo.peek() + hi.peek()) / 2.0D;
    }
}
