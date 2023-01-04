package leetcode._205;

import java.util.Arrays;

public class IsomorphicStrings {

    private final int[] st = new int[128];
    private final int[] ts = new int[128];

    public IsomorphicStrings() {
        Arrays.fill(st, -1);
        Arrays.fill(ts, -1);
    }

    public boolean isIsomorphic(String s, String t) {
        for (int i = 0; i < s.length(); i++) {
            if (st[s.charAt(i)] == -1 && ts[t.charAt(i)] == -1) {
                st[s.charAt(i)] = t.charAt(i);
                ts[t.charAt(i)] = s.charAt(i);
                continue;
            }

            if (s.charAt(i) != ts[t.charAt(i)] || t.charAt(i) != st[s.charAt(i)]) {
                return false;
            }
        }

        return true;
    }
}