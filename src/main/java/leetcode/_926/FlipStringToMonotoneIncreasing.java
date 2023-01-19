package leetcode._926;

public class FlipStringToMonotoneIncreasing {

    public int minFlipsMonoIncr(String s) {

        var counter = 0;
        for (var i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0') counter++;
        }

        var incrIndex = counter;

        for (var i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '0')
                incrIndex = Integer.min(incrIndex, --counter);
            else
                counter++;
        }

        return incrIndex;
    }

    int dp(String s) {
        int n = s.length();
        int[] counts = new int[n];
        counts[0] = s.charAt(0) - '0';

        for (int i = 1; i < n; i++) {
            counts[i] = counts[i - 1] + s.charAt(i) - '0';
        }

        int lastIndex = n - 1, antiLength = lastIndex,
                last = counts[lastIndex], min = Math.min(last, n - last),
                count;

        for (int i = 0; i < lastIndex; i++) {
            count = counts[i];
            min = Math.min(min, (count << 1) + antiLength - last);
            antiLength--;
        }

        return min;
    }
}
