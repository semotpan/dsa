package leetcode._352;

import java.util.*;

public class DataStreamAsDisjointIntervals {
}

class SummaryRanges {

    private final NavigableMap<Integer, Integer> intervals;

    public SummaryRanges() {
        intervals = new TreeMap<>();
    }

    public void addNum(int value) {

        int lower = value, higher = value;

        var lowerEntry = intervals.floorEntry(value);
        // fix lower bound
        if (Objects.nonNull(lowerEntry)) {
            var prevHigh = lowerEntry.getValue();

            if (prevHigh >= value) return; // value is already part of current interval

            if (prevHigh + 1 == value)
                lower = lowerEntry.getKey();
        }

        // fix higher bound
        var higherEntry = intervals.higherEntry(value);
        if (Objects.nonNull(higherEntry) && higherEntry.getKey() - 1 == value) {
            higher = higherEntry.getValue();
            intervals.remove(higherEntry.getKey()); // remove higher key, will part of lower key
        }

        intervals.put(lower, higher);
    }

    public int[][] getIntervals() {
        var values = new int[intervals.size()][2];
        var index = 0;

        for (var entry : intervals.entrySet()) {
            values[index][0] = entry.getKey();
            values[index][1] = entry.getValue();
            ++index;
        }

        return values;
    }
}

class SummaryRanges3 {
    private final BitSet marked;
    private int min, max;

    public SummaryRanges3() {
        this.marked = new BitSet(10001);
        this.min = 10_001;
        this.max = -1;
    }

    public void addNum(int value) {
        marked.set(value, true);
        min = Integer.min(min, value);
        max = Integer.max(max, value);
    }

    public int[][] getIntervals() {
        var intervals = new ArrayList<int[]>(max - min);

        for (int i = min; i <= max; ++i) {
            if (!marked.get(i)) continue;

            var interval = new int[]{i, i};

            while (marked.get(++i)){
                interval[1] = i;
            }

            intervals.add(interval);
        }


        return intervals.toArray(new int[intervals.size()][2]);
    }
}

class SummaryRanges2 {
    private final boolean[] marked;
    private int min, max;

    public SummaryRanges2() {
        this.marked = new boolean[10_001];
        this.min = 10_001;
        this.max = -1;
    }

    public void addNum(int value) {
        marked[value] = true;
        min = Integer.min(min, value);
        max = Integer.max(max, value);
    }

    public int[][] getIntervals() {
        var intervals = new ArrayList<int[]>();

        for (int i = min; i <= max; ++i) {
            if (!marked[i]) continue;

            var interval = new int[]{i, i};

            while (marked[++i]){
                interval[1] = i;
            }

            intervals.add(interval);
        }


        return intervals.toArray(new int[intervals.size()][2]);
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(value);
 * int[][] param_2 = obj.getIntervals();
 */
