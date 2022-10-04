package leetcode._678;

public class ValidParenthesisString {
    public boolean checkValidString(String s) {
        var low = 0;
        var high = 0;

        for (char c : s.toCharArray()) {
            switch (c) {
                case '(' -> {
                    low++;
                    high++;
                }
                case ')' -> {
                    low--;
                    high--;
                }
                case '*' -> {
                    low--;
                    high++;
                }
            }
//            low += c == '(' ? 1 : -1;
//            high += c != ')' ? 1 : -1;
            if (high < 0) {
                break;
            }
            low = Integer.max(low, 0);
        }

        return low == 0;
    }
}
