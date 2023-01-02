package leetcode._295;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// Time Exceeded
public class FindMedianFromDataStream_Sorting {

    private List<Integer> data;

    public FindMedianFromDataStream_Sorting() {
        data = new LinkedList<>();
    }

    public void addNum(int num) {
        data.add(num);
    }

    public double findMedian() {
        data.sort(Comparator.comparingInt(o -> o));
        var size = data.size();

        if (size == 1) {
            return data.get(0);
        }
        var mid = size/2;
        return size % 2 == 0 ? (data.get(mid - 1) + data.get(mid))/2.0 : data.get(mid);
    }
}
