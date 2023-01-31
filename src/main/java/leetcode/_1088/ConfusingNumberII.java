package leetcode._1088;

public class ConfusingNumberII {

    private static final int[] valid = {0, 1, 6, 8, 9};
    private static final long[] rotated = {0, 1, -1, -1, -1, -1, 9, -1, 8, 6};
    private int counter;

    public int confusingNumberII(int n) {
        confuse(0, 0, 1, n);
        return counter;
    }

    private void confuse(long value, long rotate, int base, int limit) {
        if (value > limit) return;
        if (value != rotate) counter++;

        for (int digit : valid) {
            if (value == 0 && digit == 0) continue;
//            confuse(value * 10 + digit, base * rotated[digit] + rotate, base * 10, limit);
            confuse(((value << 1) + (value << 3)) + digit, base * rotated[digit] + rotate, ((base << 1) + (base << 3)), limit);
        }
    }
}
