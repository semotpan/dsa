package leetcode._557;

public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        char[] values = s.toCharArray();

        int low = 0, high = values.length - 1;
        int lowNonSpace = 0, highNonSpace = high;

        for (; low <= high; low++, high--) {

            if (values[low] == ' ') {
                reverseSubstring(values, lowNonSpace, low - 1);
                lowNonSpace = low + 1;
            }

            if (values[high] == ' ') {
                reverseSubstring(values, high + 1, highNonSpace);
                highNonSpace = high - 1;
            }
        }

        if (lowNonSpace < highNonSpace) {
            reverseSubstring(values, lowNonSpace, highNonSpace);
        }

        return new String(values);
    }

    private void reverseSubstring(char[] s, int low, int high) {
        char temp;
        for (int i = low, j = high; i < j; ++i, --j) {
            temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
}
