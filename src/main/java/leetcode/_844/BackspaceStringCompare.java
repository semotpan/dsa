package leetcode._844;

public class BackspaceStringCompare {

    public boolean backspaceCompare(String s, String t) {

        var sIndex = s.length() - 1;
        var tIndex = t.length() - 1;

        while (sIndex >= 0 || tIndex >= 0) {

            sIndex = nextIndex(s, sIndex);
            tIndex = nextIndex(t, tIndex);

            if (sIndex >= 0 && tIndex >= 0 && s.charAt(sIndex) != t.charAt(tIndex)) {
                return false;
            }

            if ((sIndex >= 0) != (tIndex >= 0)) {
                return false;
            }

            --sIndex;
            --tIndex;
        }

        return true;
    }

    private int nextIndex(String input, int index) {
        var skip = 0;
        while (index >= 0) {
            if (input.charAt(index) == '#') {
                skip++;
                index--;
            } else if (skip > 0) {
                skip--;
                index--;
            } else break;
        }

        return index;
    }
}
