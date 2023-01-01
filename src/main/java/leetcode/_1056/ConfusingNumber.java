package leetcode._1056;

import java.util.Map;

public class ConfusingNumber {

    final Map<Integer, Integer> catalog = Map.of(
            0, 0,
            1, 1,
            6, 9,
            8, 8,
            9, 6
    );

    public boolean confusingNumber(int n) {
        return n != confuse(n);
    }

    private int confuse(int n) {
        var rotate = 0;
        var current = n;
        while (current > 0) {
            var digit = current % 10;
            if (!catalog.containsKey(digit)) {
                return n;
            }

            rotate = rotate * 10 + catalog.get(digit);
            current /= 10;
        }

        return rotate;
    }
}
