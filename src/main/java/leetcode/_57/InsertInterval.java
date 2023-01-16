package leetcode._57;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }

        var answer = new ArrayList<int[]>(intervals.length);

        var i = 0;
        while (i < intervals.length && !isOverlap(intervals[i], newInterval)) {
            answer.add(intervals[i++]);
        }

        if (i < intervals.length && isOverlap(intervals[i], newInterval)) {
            var merged = merge(intervals[i], newInterval);

            while (i < intervals.length && isOverlap(intervals[i], merged)) {
                merged = merge(intervals[i++], merged);
            }

            answer.add(merged);
            while (i < intervals.length) {
                answer.add(intervals[i++]);
            }
        } else {
            var index = binarySearch(intervals, newInterval[1]);
            answer.add(index, newInterval);
        }

        return answer.toArray(new int[answer.size()][2]);
    }

    private boolean isOverlap(int[] a, int[] b) {
        return Integer.min(a[1], b[1]) - Integer.max(a[0], b[0]) >= 0;
    }

    private int[] merge(int[] a, int[] b) {
        return new int[]{Integer.min(a[0], b[0]), Integer.max(a[1], b[1])};
    }

    private int binarySearch(int[][] intervals, int key) {
        int low = 0, high = intervals.length - 1, mid = 0;

        while (low <= high) {
            mid = (low + high) >>> 1;

            if (key < intervals[mid][1])
                high = mid - 1;
            else if (key > intervals[mid][1])
                low = mid + 1;
            else
                return mid;
        }

        return low;
    }
}