package leetcode._20;

public class ValidParentheses {

    public boolean isValid(String s) {
        var stack = new char[s.length()];
        var top = 0;

        for (var c : s.toCharArray()) {
            switch (c) {
                case '{', '[', '(' -> stack[top++] = c;
                case '}' -> {
                    if (top == 0 || stack[--top] != '{')
                        return false;
                }
                case ']' -> {
                    if (top == 0 || stack[--top] != '[')
                        return false;
                }
                case ')' -> {
                    if (top == 0 || stack[--top] != '(')
                        return false;
                }
            }
        }

        return top == 0;
    }

}
