package leetcode._227;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculatorII {
    private final Deque<Integer> stack = new ArrayDeque<>();

    public int calculate(String s) {

        var n = 0;
        var op = '+';
        for (var c : s.toCharArray()) {
            switch (c) {
                case '+', '-', '*', '/' -> {
                    stack.push(eval(n, op));
                    op = c;
                    n = 0;
                }
                case ' ' -> {}
                default -> n = n * 10 + (c - '0');
            }
        }

        // add last number
        stack.push(eval(n, op));

        var rez = 0;
        while (!stack.isEmpty())
            rez += stack.pop();

        return rez;
    }

    private int eval(int n, char op) {
        return switch (op) {
            case '-' -> -n;
            case '*' -> stack.pop() * n;
            case '/' -> stack.pop() / n;
            default -> n;
        };
    }
}
